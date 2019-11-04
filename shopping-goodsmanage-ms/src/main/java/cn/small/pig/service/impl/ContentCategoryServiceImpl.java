package cn.small.pig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.small.pig.entity.PageResult;
import cn.small.pig.mapper.TbContentCategoryMapper;
import cn.small.pig.pojo.TbContent;
import cn.small.pig.pojo.TbContentCategory;
import cn.small.pig.pojo.TbContentCategoryExample;
import cn.small.pig.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;

	
	@Override
	public PageResult contentCategoryFindByPage(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(null);
		
		PageInfo pageInfo = new PageInfo(list);


		PageResult pageResult = new PageResult(pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),list);
		return pageResult;
	}

	@Override
	public TbContentCategory contentCategoryFindById(long id) {
		return  tbContentCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addContentCategory(TbContentCategory newContentCategory) {
		tbContentCategoryMapper.insert(newContentCategory);

	}

	@Override
	public void updateContentCategory(TbContentCategory contentCategory) {
		tbContentCategoryMapper.updateByPrimaryKey(contentCategory);

	}

	@Override
	public void deleteContentCategory(Long[] ids) {
		for(Long id:ids) {
			tbContentCategoryMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult contentCategoryFindByName(String name, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		TbContentCategoryExample example = new TbContentCategoryExample();
		TbContentCategoryExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
		PageInfo pageInfo = new PageInfo(list);
		PageResult pageResult = new PageResult(pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),list);
		return pageResult;
	}
	
	

}
