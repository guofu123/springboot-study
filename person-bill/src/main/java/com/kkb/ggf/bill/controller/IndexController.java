package com.kkb.ggf.bill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {


    @RequestMapping(path = "",method = RequestMethod.GET)
    public String index(){
        return "redirect:/bill/list/10/1";
    }
}
