package com.zjc.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.MulticastChannel;

/**
 * @Author : ZJC
 * @Date : 2020/11/10 10:53
 * className : HelloConreoller
 * package: com.zjc.controller
 * version : 1.0
 * Description
 */
@Controller
public class HelloConreoller {
    @RequestMapping(value = "/upload")
    public String upload(
            @RequestParam("username") String username,
            @RequestParam("photo") MultipartFile photo) {
        System.out.println("用户名：" + username);
        System.out.println("上传文件名：" + photo.getOriginalFilename());
        try {
            photo.transferTo(new File("E:/" + photo.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @RequestMapping(value = "download")
    public ResponseEntity<byte[]> download(HttpSession session) throws IOException {
        String fileName = "";
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //以流的方式
        InputStream resourceAsStream = servletContext.getResourceAsStream("/filess/" + fileName);
        //将输入流中的数据读取出来，转换为字节数组
        byte[] buffer = IOUtils.toByteArray(resourceAsStream);
        resourceAsStream.close();
        //获取指定路径文件的数据类型
        String mimeType = servletContext.getMimeType("/files/" + fileName);
        MultiValueMap headers = new HttpHeaders();
        //设置返回的数据类型
        headers.add("Content-Type", mimeType);
        //设置响应头 告诉浏览器收到的数据统一以附件的形式用于下载
        headers.add("Content-Disposition","attachment; filename=" + fileName);
        // 创建ResponseEneity返回客户端需要的数据
        /**
         *  ResponseEntity可以分别用来设置响应行，响应头，响应体<br/>
         *  第一个参数是响应体<br/>
         *  第二个参数是响应头<br/>
         *  第三个参数是响应状态码<br/>
         */
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(buffer,headers, HttpStatus.OK);

        return responseEntity;
    }
}
