package com.pinyougou.manager.controller;

import java.util.List;

import entity.PageResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();		
	}

	/*
	 * 功能描述: <br>
	 * 〈返回全部列表〉
	 * @Param: [page, rows]
	 * @Return: entity.PageResult
	 * @Author: Administrator
	 * @Date: 2019/8/22 0022 23:36
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return brandService.findPage(page, rows);
	}
}
