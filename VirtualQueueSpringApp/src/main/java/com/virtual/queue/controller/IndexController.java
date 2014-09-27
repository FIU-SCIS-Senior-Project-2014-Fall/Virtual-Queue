package com.virtual.queue.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created with IntelliJ IDEA.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String getIndexPage() {
        return "index";
    }
}
