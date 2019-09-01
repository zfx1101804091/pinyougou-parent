package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

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

	/*
	 * 功能描述: <br>
	 * 〈品牌增加〉
	 * @Param: [brand]
	 * @Return: void
	 * @Author: Administrator
	 * @Date: 2019/8/23 0023 7:17
	 */
	public void add(TbBrand brand);
	
	/*
	 * 功能描述: <br>
	 * 〈修改品牌〉
	 * @Param: [brand]
	 * @Return: void
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 21:34
	 */
	public void update(TbBrand brand);

	/*
	 * 功能描述: <br>
	 * 〈根据id获取品牌〉
	 * @Param: [id]
	 * @Return: com.pinyougou.pojo.TbBrand
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 21:34
	 */
	public TbBrand findOne(Long id);

	/*
	 * 功能描述: <br>
	 * 〈根据选中的id--删除商品〉
	 * @Param: [ids]
	 * @Return: void
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 22:18
	 */
	public void delete(Long [] ids);

	/*
	 * 功能描述: <br>
	 * 〈分页〉
	 * @Param: [brand, pageNum当前页码, pageSize每页记录数]
	 * @Return: entity.PageResult
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 23:06
	 */
	public PageResult findPage(TbBrand brand, int pageNum,int pageSize);

	/**
	 * 品牌下拉框数据
	 */
	List<Map> selectOptionList();
}
