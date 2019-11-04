package cn.small.pig.service;

import java.util.List;

import cn.small.pig.entity.PageResult;
import cn.small.pig.pojo.TbContentCategory;


public interface ContentCategoryService {
	public PageResult contentCategoryFindByPage(int pageNo,int pageSize);
	public TbContentCategory contentCategoryFindById(long id);
	public void addContentCategory(TbContentCategory newContentCategory);
	public void updateContentCategory(TbContentCategory contentCategory);
	public void deleteContentCategory(Long[] ids);
	public PageResult contentCategoryFindByName(String name,int pageNo,int pageSize);
}
