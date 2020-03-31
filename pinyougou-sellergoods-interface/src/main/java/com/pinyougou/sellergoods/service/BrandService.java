package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;
import entity.Result;

import java.util.List;

/**
 * 品牌服务层接口
 *
 * @author Fan
 * @version 1.0
 * @date 2020/3/29 21:04
 */
public interface BrandService {

    /**
     * 查找所有的品牌信息
     *
     * @return 所有品牌信息
     */
    public List<TbBrand> findAll();

    /**
     * 品牌分页
     *
     * @param pageNum  当前页码
     * @param pageSize 页大小
     * @return 分页实体
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加品牌
     *
     * @param brand 品牌
     * @return Result 结果集
     */
    public Result add(TbBrand brand);
}
