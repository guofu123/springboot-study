package com.kkb.my.travle.controller;

import com.kkb.my.travle.domain.Category;
import com.kkb.my.travle.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 线路分类控制器
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    private final static String PREFIX = "category";

    /**
     * 查询所有，不分页
     * @param model
     * @return
     */
    @RequestMapping(path = "/list")
    public String list(Model model){
        List<Category> list = categoryService.list();
        model.addAttribute("list",list);
        return PREFIX + "/list";
    }

    @RequestMapping(path = "/toAdd")
    public String toAdd(){
        return PREFIX + "/add";
    }

    @RequestMapping("/add")
    public String add(Category category){
        categoryService.add(category);
        return "redirect:/admin/category/list";
    }

    @RequestMapping("/toUpdate/{cid}")
    public String toUpdate(@PathVariable("cid")Integer cid,
                           Model model){
        Category category = categoryService.getById(cid);
        model.addAttribute("category",category);
        return PREFIX + "/update";
    }

    @RequestMapping("/update")
    public String update(Category category){
        categoryService.update(category);
        return "redirect:/admin/category/list";
    }

    @RequestMapping("/delete/{cid}")
    public String delete(Integer cid){
        categoryService.delete(cid);
        return  "redirect:/admin/category/list";
    }

}
















