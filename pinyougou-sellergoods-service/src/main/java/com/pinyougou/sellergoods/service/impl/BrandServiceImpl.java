package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;
	
	@Override
	public List<TbBrand> findAll() {

		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int pageNum, int pageSize) {

		PageHelper.startPage(pageNum,pageSize);
		Page<TbBrand> page=   (Page<TbBrand>)brandMapper.selectByExample(null);
		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
	}

	/*
	 * 功能描述: <br>
	 * 〈修改品牌〉
	 * @Param: [brand]
	 * @Return: void
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 21:37
	 */
	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
	}

	/*
	 * 功能描述: <br>
	 * 〈根据id获取品牌实体〉
	 * @Param: [id]
	 * @Return: com.pinyougou.pojo.TbBrand
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 21:37
	 */
	@Override
	public TbBrand findOne(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	/*
	 * 功能描述: <br>
	 * 〈批量删除〉
	 * @Param: [ids]
	 * @Return: void
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 22:20
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
	}

	/*
	 * 功能描述: <br>
	 * 〈查询+分页〉
	 * @Param: [brand, pageNum, pageSize]
	 * @Return: entity.PageResult
	 * @Author: Administrator
	 * @Date: 2019/8/24 0024 23:09
	 */
	@Override
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbBrandExample example=new TbBrandExample();
		TbBrandExample.Criteria criteria = example.createCriteria();
		if(brand!=null){
			if(brand.getName()!=null && brand.getName().length()>0){
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
				criteria.andFirstCharEqualTo(brand.getFirstChar());
			}
		}
		Page<TbBrand> page= (Page<TbBrand>)brandMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
		
	}

}
