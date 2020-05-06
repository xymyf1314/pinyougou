package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 品牌的控制层
 *
 * @author Fan
 * @version 1.0
 * @date 2020/3/29 21:15
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int size) {
        return brandService.findPage(page, size);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand) {
        return brandService.add(brand);
    }

    @RequestMapping("findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand) {
        return brandService.update(brand);
    }

    @RequestMapping("/delete")
    public Result update(Long[] ids) {
        return brandService.delete(ids);
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand, int page, int size) {
        return brandService.findPage(brand, page, size);
    }
    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }

}
