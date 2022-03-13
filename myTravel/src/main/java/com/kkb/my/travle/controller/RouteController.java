package com.kkb.my.travle.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.my.travle.domain.Category;
import com.kkb.my.travle.domain.Route;
import com.kkb.my.travle.domain.Seller;
import com.kkb.my.travle.property.CommonProperties;
import com.kkb.my.travle.service.CategoryService;
import com.kkb.my.travle.service.RouteService;
import com.kkb.my.travle.service.SellerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/admin/route")
@Controller
public class RouteController {

    @Resource
    private RouteService routeService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private SellerService sellerService;

    @RequestMapping("/page")
    public String page(Route route,
                       @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                       @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                       Model model){
        // 查找上架的旅游路线
        route.setRflag("1");
        PageInfo<Route> page = routeService.findPage(route, pageNum, pageSize);
        List<Category> categories = categoryService.list();
        List<Seller> sellers = sellerService.findList(null);
        model.addAttribute("page", page);
        model.addAttribute("categories",categories);
        model.addAttribute("sellers",sellers);
        return "/route/list";
    }

    @RequestMapping("/toAdd")
    public String toAddPage(Model model){
        List<Category> categories = categoryService.list();
        List<Seller> sellers = sellerService.findList(null);
        model.addAttribute("categories",categories);
        model.addAttribute("sellers",sellers);
        return "/route/add";
    }

    @RequestMapping("/add")
    public String add(Route route, @RequestParam("rimageFile") MultipartFile rimageFile, Model model,
                      HttpServletRequest request) throws IOException {
        // 文件保存和生成新的文件名
        String path = CommonProperties.getFileUploadPath();
        File filePath = new File(path + "\\img\\product\\route\\");
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        String fileName = UUID.randomUUID().toString().replace("-","") + "." + FilenameUtils.getExtension(rimageFile.getOriginalFilename());
        rimageFile.transferTo(new File(filePath, fileName));
        route.setRimage("img/product/route/" +fileName);
        routeService.add(route);
        return "redirect:/admin/route/page";
    }


    @RequestMapping("/toUpdate/{rid}")
    public String toUpdatePage(Model model, @PathVariable("rid")Integer rid){
        Route route = routeService.findById(rid);
        List<Category> categories = categoryService.list();
        List<Seller> sellers = sellerService.findList(null);
        model.addAttribute("route", route);
        model.addAttribute("categories",categories);
        model.addAttribute("sellers",sellers);
        return "/route/update";
    }

    @RequestMapping("/update")
    public String update(Route route,@RequestParam("rimageFile")MultipartFile rimageFile) throws IOException {
        if (rimageFile!=null){
            // 删除原来的图片，使用新上传的图片
            Route route1 = routeService.findById(route.getRid());
            if (route1.getRimage()!=null){
                FileSystemUtils.deleteRecursively(new File(CommonProperties.getFileUploadPath() + File.separator + route1.getRimage()));
            }
            // 文件保存和生成新的文件名
            String path = CommonProperties.getFileUploadPath();
            File filePath = new File(path + "\\img\\product\\route\\");
            if (!filePath.exists()){
                filePath.mkdirs();
            }
            String fileName = UUID.randomUUID().toString().replace("-","") + "." + FilenameUtils.getExtension(rimageFile.getOriginalFilename());
            rimageFile.transferTo(new File(filePath, fileName));
            route.setRimage("img/product/route/" +fileName);
        }
        routeService.update(route);
        return "redirect:/admin/route/page";
    }

    @RequestMapping("/delete/{rid}")
    public String delete(@PathVariable("rid") Integer rid){
        routeService.delete(rid);
        return "redirect:/admin/route/page";
    }



}
