package com.kkb.my.travle.controller;


import com.github.pagehelper.PageInfo;
import com.kkb.my.travle.domain.Seller;
import com.kkb.my.travle.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 销售控制器
 */
@RequestMapping("/admin/seller")
@Controller
public class SellerController {

    @Resource
    private SellerService sellerService;

    private static final String PREFIX = "/seller";

    @RequestMapping("/page")
    public String queryPage(Seller seller,
                     @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                     @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                            Model model){
        PageInfo<Seller> page = sellerService.findPage(seller, pageNum, pageSize);
        model.addAttribute("page",page);
        return PREFIX + "/list";
    }

    @RequestMapping("/toUpdate/{sid}")
    public String toUpdatePage(@PathVariable("sid")Integer sid, Model model){
        Seller seller = sellerService.findById(sid);
        model.addAttribute(seller);
        return PREFIX + "/update";
    }

    @RequestMapping("/update")
    public String doUpdate(Seller seller){
        sellerService.update(seller);
        return "redirect:/admin" + PREFIX + "/page";
    }

    @RequestMapping("/toAdd")
    public String toAddPage(){
        return PREFIX + "/add";
    }

    @RequestMapping("/add")
    public String add(Seller seller){
        sellerService.add(seller);
        return "redirect:/admin" + PREFIX + "/page";
    }
}
