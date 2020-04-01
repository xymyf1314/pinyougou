package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
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

    /**
     * 查找所有的品牌信息
     *
     * @return 所有品牌信息
     */
    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    /**
     * 品牌分页
     *
     * @param pageNum  当前页码
     * @param pageSize 页大小
     * @return 分页实体
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        // mybatis的分页
        PageHelper.startPage(pageNum, pageSize);
        Page<TbBrand> page = (Page) (tbBrandMapper.selectByExample(null));
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加品牌
     *
     * @param brand 品牌
     * @return Result 结果集
     */
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

    /**
     * 根据id查询实体
     *
     * @param id id
     * @return TbBrand
     */
    @Override
    public TbBrand findOne(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改
     *
     * @param brand 修改后的品牌
     */
    @Override
    public Result update(TbBrand brand) {
        try {
            tbBrandMapper.updateByPrimaryKey(brand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 删除
     *
     * @param ids 待删除的id数组
     */
    @Override
    public Result delete(Long[] ids) {
        try {
            for (Long id : ids) {
                tbBrandMapper.deleteByPrimaryKey(id);
            }
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }

    }

    /**
     * 品牌的条件查询
     *
     * @param brand
     * @param pageNum  页码
     * @param pageSize 页大小
     * @return 分页实体
     */
    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbBrandExample example = new TbBrandExample();
        // 构建条件
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (brand != null) {
            if (brand.getName() != null && brand.getName().length() > 0) {
                criteria.andNameLike("%" + brand.getName() + "%");
            }
            if (brand.getFirstChar() != null && brand.getFirstChar().length() > 0) {
                criteria.andFirstCharLike("%" + brand.getFirstChar() + "%");
            }
        }
        Page<TbBrand> page = (Page) (tbBrandMapper.selectByExample(example));
        return new PageResult(page.getTotal(), page.getResult());
    }

}
