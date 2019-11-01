package com.example.demo12.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * IndexController
 * https://segmentfault.com/a/1190000013644784
 * https://github.com/mymmyy/http2-demo/tree/master/http2-springBoot-demo/src/main/java/com/example/demo/controller
 *
 * @author dusk
 * @since 01/11/2019
 */
@RestController
public class IndexController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @Value("classpath:demo.png")
    Resource resource;

    @GetMapping("/demo")
    public void http2ServerPush(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PushBuilder pushBuilder = request.newPushBuilder();
        pushBuilder.path("/demo.png")
                .addHeader("content-type", "image/png")
                .push();
        try (PrintWriter respWriter = response.getWriter()) {
            respWriter.write("<html>" +
                    "<img src='/demo.png'>" +
                    "</html>");
        }
    }

    @GetMapping(value = "/demo.png")
    public void download(HttpServletResponse response) throws IOException {
        InputStream data = resource.getInputStream();
        response.setHeader("content-type", "image/png");
        FileCopyUtils.copy(data, response.getOutputStream());
    }
}
