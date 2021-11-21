package com.hzhu.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @authod: pp_lan on 2020/7/11.
 */
@RequestMapping("/api/v1/index")
public class IndexController {

    @RequestMapping(value = "index", method = {RequestMethod.GET, RequestMethod.POST})
    public String index() {
        return "index";
    }
}
