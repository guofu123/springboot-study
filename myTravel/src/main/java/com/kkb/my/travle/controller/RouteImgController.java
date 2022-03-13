package com.kkb.my.travle.controller;

import com.kkb.my.travle.domain.Route;
import com.kkb.my.travle.domain.RouteImg;
import com.kkb.my.travle.property.CommonProperties;
import com.kkb.my.travle.service.RouteImgService;
import com.kkb.my.travle.service.RouteService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 路线图片编辑控制器
 */
@RequestMapping("/admin/route")
@Controller
public class RouteImgController {

    @Resource
    private RouteImgService routeImgService;
    @Resource
    private RouteService routeService;

    /**
     * 去图片编辑页面
     * @param rid
     * @param model
     * @return
     */
    @RequestMapping("/toImage/{rid}")
    public String toImageEdit(@PathVariable("rid")Integer rid,
                              Model model){
        Route route = routeService.findById(rid);
        model.addAttribute("route", route);
        return "/route/image";
    }

    @RequestMapping("/saveImgs")
    public String saveImgs(Integer rid,
                           @RequestParam("bigPicFile")MultipartFile[] bigPicFile,
                           @RequestParam("smallPicFile")MultipartFile[] smallPicFile,
                           Model model ) throws IOException {
        ArrayList<RouteImg> routeImgs = new ArrayList<>();
        ArrayList<String> bigPicPath = new ArrayList<>();
        ArrayList<String> smallPicPath = new ArrayList<>();

        // 先保存图片
        String uploadPath1 = CommonProperties.getFileUploadPath() + "\\img\\product\\bigPic\\";
        File filePath1 = new File(uploadPath1);
        if (!filePath1.exists()){
            filePath1.mkdirs();
        }
        String uploadPath2 = CommonProperties.getFileUploadPath() + "\\img\\product\\smallPic\\";
        File filePath2 = new File(uploadPath2);
        if (!filePath2.exists()){
            filePath2.mkdirs();
        }
        /* 大图 */
        for (MultipartFile mf : bigPicFile) {
            String fName = UUID.randomUUID().toString().replace("-","") + '.'
                    + FilenameUtils.getExtension(mf.getOriginalFilename());
            mf.transferTo(new File(filePath1, fName));
            bigPicPath.add("img/product/bigPic/" + fName);
        }
        /* 小图 */
        for (MultipartFile mf : smallPicFile) {
            String fName = UUID.randomUUID().toString().replace("-","") + '.'
                    + FilenameUtils.getExtension(mf.getOriginalFilename());
            mf.transferTo(new File(filePath2, fName));
            smallPicPath.add("img/product/smallPic/" + fName);
        }
        /* 封住数据库保存的对象，上传的大图和小图数量要相等 */
        for (int i = 0; i < bigPicPath.size(); i++) {
            RouteImg routeImg = new RouteImg();
            routeImg.setRid(rid);
            routeImg.setBigpic(bigPicPath.get(i));
            routeImg.setSmallpic(smallPicPath.get(i));
            routeImgs.add(routeImg);
        }
        Route oldRoute = routeService.findById(rid);
        /* 执行数据库保存 */
        routeImgService.saveImgs(rid, routeImgs);
        // 然后删除旧的图片
        List<RouteImg> oldRouteImgList = oldRoute.getRouteImgList();
        for (RouteImg ri : oldRouteImgList){
            String smallpic = ri.getSmallpic();
            String bigpic = ri.getBigpic();
            FileSystemUtils.deleteRecursively(new File(uploadPath2 + File.separator + smallpic));
            FileSystemUtils.deleteRecursively(new File(uploadPath1 + File.separator + bigpic));
        }
        return "redirect:/admin/route/page";
    }


}

















