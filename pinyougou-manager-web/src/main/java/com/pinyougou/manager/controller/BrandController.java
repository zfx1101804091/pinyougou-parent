package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import entity.PageResult;
import entity.Result;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {
	private static final Logger logger = Logger.getLogger(BrandController.class);

	@Reference
	private BrandService brandService;
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		logger.debug("/findAll---"+brandService.findAll().toString());
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

	/*
	 * 功能描述: <br>
	 * 〈商品增加〉
	 * @Param: [brand]
	 * @Return: entity.Result
	 * @Author: Administrator
	 * @Date: 2019/8/23 0023 7:33
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand){
		try {
			brandService.add(brand);
			logger.debug("/add---"+"新增成功"+System.currentTimeMillis());
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}

	/*
	 * 功能描述: <br>
	 * 〈修改品牌列表〉
	 * @Param: [brand]
	 * @Return: entity.Result
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 21:41
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand){
		try {
			brandService.update(brand);
			logger.debug("/update---"+"修改成功"+System.currentTimeMillis());
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}
	
	/*
	 * 功能描述: <br>
	 * 〈根据id获取实体〉
	 * @Param: [id]
	 * @Return: com.pinyougou.pojo.TbBrand
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 21:42
	 */
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id){
		logger.debug("/findOne---"+ brandService.findOne(id));
		return brandService.findOne(id);
	}

	/*
	 * 功能描述: <br>
	 * 〈批量删除〉
	 * @Param: [ids]
	 * @Return: entity.Result
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 22:22
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids){
		try {
			brandService.delete(ids);
			logger.debug("/delete---"+ ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("/delete---"+ e.getMessage());
			return new Result(false, "删除失败");
		}
	}

	/*
	 * 功能描述: <br>
	 * 〈查询+分页〉
	 * @Param: [brand, page, rows]
	 * @Return: entity.PageResult
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 23:10
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand, int page, int rows  ){
		logger.debug("/search---"+ brandService.findPage(brand, page, rows));
		return brandService.findPage(brand, page, rows);
	}

	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return brandService.selectOptionList();
	}
}
