package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	/*
	 * 功能描述: <br>
	 * 〈品牌管理-查询所有〉
	 * @Param: []
	 * @Return: java.util.List<com.pinyougou.pojo.TbBrand>
	 * @Author: zheng-fx
	 * @Date: 2019/8/22 0022 23:28
	 */
	public List<TbBrand> findAll();

	/*
	 * 功能描述: <br>
	 * 〈返回分页列表〉
	 * @Param: [pageNum, pageSize]
	 * @Return: entity.PageResult
	 * @Author: zheng-fx
	 * @Date: 2019/8/22 0022 23:30
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
}
