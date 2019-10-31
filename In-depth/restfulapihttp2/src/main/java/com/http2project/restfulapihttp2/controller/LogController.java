package com.http2project.restfulapihttp2.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dusk
 * @since 2019/11/1 2:01
 */
@RestController
@RequestMapping(value = "/log")
@Log4j2
public class LogController {
    @GetMapping("/info")
    public String info() {
        log.info("Info log");
        return "info";
    }
}
