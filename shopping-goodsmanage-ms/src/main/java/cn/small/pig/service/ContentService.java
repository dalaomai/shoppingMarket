package cn.small.pig.service;

import java.util.List;

import cn.small.pig.entity.PageResult;
import cn.small.pig.pojo.TbContent;

public interface ContentService {
	public PageResult contentFindByPage(int pageNo,int pageSize);
	public TbContent contentFindById(long id);
	public void addContent(TbContent newContent);
	public void updateContent(TbContent content);
	public void deleteContent(Long[] ids);
	public List<TbContent> contentFindByCategoryId(Long categoryId);
}
