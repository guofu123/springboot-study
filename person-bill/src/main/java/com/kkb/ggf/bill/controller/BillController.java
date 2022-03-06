package com.kkb.ggf.bill.controller;

import com.github.pagehelper.PageInfo;
import com.kkb.ggf.bill.pojo.BillType;
import com.kkb.ggf.bill.pojo.BillVo;
import com.kkb.ggf.bill.service.BillTypeService;
import com.kkb.ggf.bill.service.BillVoService;
import com.kkb.ggf.bill.vo.BillSearchVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/bill")
@Controller
public class BillController {

    @Resource
    private BillVoService billVoService;
    @Resource
    private BillTypeService billTypeService;

    // 返回页面的前缀
    private final String PREFIX = "bill";

    // 返回默认第一页
    private final String FIRST_PAGE = "/" + PREFIX + "/list/5/1";

    /**
     * 首页分页显示
     */
    @RequestMapping(path = "list/{pageSize}/{pageNum}",method = RequestMethod.GET)
    public String list(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum, BillSearchVo vo, Model model){
        // 查询分页数据
        PageInfo<BillVo> page = billVoService.getListPage(vo, pageSize, pageNum);
        // 获取所有账单类型
        List<BillType> billTypes = billTypeService.getAllBillType();
        model.addAttribute("page",page);
        model.addAttribute("billTypes",billTypes);
        if (vo==null){
            vo = new BillSearchVo();
        }
        model.addAttribute("vo",vo);
        return PREFIX + "/list";
    }

    /**
     * 去添加页面，并获取账单类型数据
     * @return
     */
    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public String toAddPage(Model model){
        List<BillType> billTypes = billTypeService.getAllBillType();
        model.addAttribute("billTypes",billTypes);
        return PREFIX + "/add";
    }

    /**
     * 新增记录
     * @param record
     * @return
     */
    @RequestMapping(path = "",method = RequestMethod.POST)
    public String addOneBill(BillVo record){
        // 调用service的方法
        int i = billVoService.addOneBill(record);
        if (i>0){
            return "redirect:" + FIRST_PAGE;
        }else {
            return "redirect:" + PREFIX + "/toAdd";
        }
    }

    /**
     * 去编辑页面，并获取账单类型数据和当前账单记录的信息
     * @return
     */
    @RequestMapping(value = "/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("id")Long id, Model model){
        // 查询所有的账单类型
        List<BillType> billTypes = billTypeService.getAllBillType();
        model.addAttribute("billTypes",billTypes);
        // 查询当前的账单记录
        BillVo oldVo = billVoService.getBillVoById(id);
        // 不存在返回列表页面
        if (oldVo==null){
            return "redirect:" + FIRST_PAGE;
        }
        model.addAttribute("oldBill",oldVo);
        // 存在跳转到更新页面
        return PREFIX + "/update";
    }
    /**
     * 更新账单记录
     * @param record
     * @return
     */
    @RequestMapping(path = "",method = RequestMethod.PUT)
    public String updateOneBill(BillVo record){
        int i = billVoService.updateOneBill(record);
        if (i>0){
            return "redirect:" + FIRST_PAGE;
        }else {
            return "redirect:" + PREFIX + "/toUpdate/" +record.getId();
        }
    }

    /**
     * 删除账单记录
     * @param id 账单id
     * @return
     */
    @RequestMapping(path = "delete/{id}")
    public String deleteOneBill(@PathVariable("id")Long id) throws Exception {
        if (id<0)
            return "401";
        int i = billVoService.deleteOneBill(id);
        if (i>0){
            return "redirect:" + FIRST_PAGE;
        }else {
            throw new Exception("删除失败!");
        }
    }


}
