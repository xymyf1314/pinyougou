package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;
import entity.Result;

import java.util.List;
import java.util.Map;

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
    List<TbBrand> findAll();

    /**
     * 品牌分页
     *
     * @param pageNum  当前页码
     * @param pageSize 页大小
     * @return 分页实体
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 增加品牌
     *
     * @param brand 品牌
     * @return Result 结果集
     */
    Result add(TbBrand brand);

    /**
     * 根据id查询实体
     *
     * @param id id
     * @return TbBrand
     */
    TbBrand findOne(Long id);

    /**
     * 修改
     *
     * @param brand 修改后的品牌
     */
    Result update(TbBrand brand);

    /**
     * 删除
     *
     * @param ids 待删除的id数组
     */
    Result delete(Long[] ids);

    /**
     * 品牌的条件查询
     *
     * @param brand
     * @param pageNum  页码
     * @param pageSize 页大小
     * @return 分页实体
     */
    PageResult findPage(TbBrand brand, int pageNum, int pageSize);

    /**
     *  品牌下拉框数据
     * @return 品牌数据
     */
    List<Map> selectOptionList();
}
