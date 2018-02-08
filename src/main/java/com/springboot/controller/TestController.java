package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.annotation.TestAnnotation;

@RestController
@RequestMapping("/test")
public class TestController {

    @TestAnnotation(name="abc")
    @RequestMapping("/show")
    public String show() {
        return "OK";
    }

    @RequestMapping("/show2")
    public String show2() {
        return "OK2";
    }
}