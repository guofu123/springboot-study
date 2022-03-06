package com.kkb.my.travle.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.my.travle.domain.User;
import com.kkb.my.travle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param user 查询条件
     * @param pageSize 页大小
     * @param pageNum 页码
     * @param model 返回到前端的数据
     * @return 跳转的列表页面
     */
    @RequestMapping("/page")
    public String queryPage(User user,
                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            Model model){
        user.setStatus("Y");
        PageInfo<User> page = userService.findPage(user, pageNum, pageSize);
        model.addAttribute("page", page);
        return "/user/list";
    }

    /**
     * 去添加用户页面
     * @return 跳转到添加页面
     */
    @RequestMapping("/toAdd")
    public String toAddPage(){
        return "/user/add";
    }

    /**
     * 添加用户
     * 没有对添加失败的前端返回值，和前端处理；更新操作和删除操作也是；也没有做后端数据校验
     * @param user 添加的用户信息
     * @return 用户列表页面
     */
    @RequestMapping("/add")
    public String doAdd(User user){
        userService.add(user);
        return "redirect:/admin/user/page";
    }

    /**
     * 去编辑用户页面
     * @param uid 用户id
     * @param model 返回的用户信息
     * @return 跳转到编辑用户的页面
     */
    @RequestMapping("/toUpdate/{uid}")
    public String toUpdatePage(@PathVariable("uid")Integer uid, Model model){
        User user = userService.findById(uid);
        model.addAttribute("user",user);
        return "/user/update";
    }

    /**
     * 更新用户信息的请求
     * @param user 更新的用户信息，需要根据主键进行更新
     * @return 用户列表页面
     */
    @RequestMapping("/update")
    public String doUpdate(User user){
        userService.update(user);
        return "redirect:/admin/user/page";
    }

    /**
     * 删除用户信息
     * @param uid 用户id
     * @return 用户列表页面
     */
    @RequestMapping("delete/{uid}")
    public String delete(@PathVariable("uid")Integer uid){
        User user = new User();
        user.setUid(user.getUid());
        user.setStatus("N");
        userService.update(user);
        return "redirect:/admin/user/page";
    }

}
