package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;

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
     * @return
     */
    public List<TbBrand> findAll();
}
