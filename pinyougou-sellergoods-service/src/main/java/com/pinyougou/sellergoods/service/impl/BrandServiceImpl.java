package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Fan
 * @version 1.0
 * @date 2020/3/29 21:09
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        // mybatis的分页
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page) (tbBrandMapper.selectByExample(null));
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public Result add(TbBrand brand) {
        List<TbBrand> lists = this.findAll();
        int flag = 0;
        for (TbBrand tbBrand : lists) {
            if (tbBrand.getName().equals(brand.getName())) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            tbBrandMapper.insert(brand);
            return new Result(true, "增加成功");
        } else if (flag == 1) {
            return new Result(false, "已经存在该品牌");
        } else {
            return new Result(false, "增加失败");
        }
    }

}
