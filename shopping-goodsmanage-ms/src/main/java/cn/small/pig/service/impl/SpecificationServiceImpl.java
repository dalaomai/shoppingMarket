package cn.small.pig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.small.pig.entity.PageResult;
import cn.small.pig.mapper.TbSpecificationMapper;
import cn.small.pig.mapper.TbSpecificationOptionMapper;
import cn.small.pig.pojo.TbBrand;
import cn.small.pig.pojo.TbSpecification;
import cn.small.pig.pojo.TbSpecificationExample;
import cn.small.pig.pojo.TbSpecificationOption;
import cn.small.pig.pojo.TbSpecificationOptionExample;
import cn.small.pig.pojogroup.Specification;
import cn.small.pig.service.SpecificationService;

@Service
public class SpecificationServiceImpl implements SpecificationService {
	@Autowired
	private TbSpecificationMapper tbSpecificationMapper;
	@Autowired
	private TbSpecificationOptionMapper tbSpecificationOptionMapper;
	
	@Override
	public PageResult specificationFindByPage(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		List<TbSpecification> SpecificationList = tbSpecificationMapper.selectByExample(null);
		
		PageInfo pageInfo = new PageInfo(SpecificationList);


		PageResult pageResult = new PageResult(pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),SpecificationList);
		return pageResult;
	}
	
	@Override
	public Specification specificationFindById(long id) {
		Specification specification = new Specification();
		specification.setSpecification(tbSpecificationMapper.selectByPrimaryKey(id));  
		
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<TbSpecificationOption> list = tbSpecificationOptionMapper.selectByExample(example);
		specification.setSpecificationOptionList(list);
		return specification;
		
	}

	@Override
	public void addSpecification(Specification newSpecification) {
		tbSpecificationMapper.insert(newSpecification.getSpecification());
		
		for(TbSpecificationOption specificationOption:newSpecification.getSpecificationOptionList()) {
			specificationOption.setSpecId(newSpecification.getSpecification().getId());
			tbSpecificationOptionMapper.insert(specificationOption);
		}
		return;
		
	}

	@Override
	public void updateSpecification(Specification specification) {
		tbSpecificationMapper.updateByPrimaryKey(specification.getSpecification());
		
		//先删除全部，再添加
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(specification.getSpecification().getId());
		tbSpecificationOptionMapper.deleteByExample(example);
		
		for(TbSpecificationOption specificationOption:specification.getSpecificationOptionList()) {
			specificationOption.setSpecId(specification.getSpecification().getId());
			tbSpecificationOptionMapper.insert(specificationOption);
		}
		return;
		
	}

	@Override
	public void deleteSpecification(Long[] ids) {
		for(Long id:ids) {
			tbSpecificationMapper.deleteByPrimaryKey(id);
			
			TbSpecificationOptionExample example = new TbSpecificationOptionExample();
			TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			tbSpecificationOptionMapper.deleteByExample(example);
		}
		
	}

	@Override
	public PageResult specificationFindByName(String name,int pageNo,int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		TbSpecificationExample example = new TbSpecificationExample();
		TbSpecificationExample.Criteria criteria = example.createCriteria();
		criteria.andSpecNameEqualTo(name);
		List<TbSpecification> list = tbSpecificationMapper.selectByExample(example);
		PageInfo pageInfo = new PageInfo(list);
		PageResult pageResult = new PageResult(pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),list);
		return pageResult;
	}
	
	
	
}
