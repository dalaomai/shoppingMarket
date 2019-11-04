package cn.small.pig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.small.pig.entity.PageResult;
import cn.small.pig.mapper.TbBrandMapper;
import cn.small.pig.mapper.TbContentMapper;
import cn.small.pig.pojo.TbBrand;
import cn.small.pig.pojo.TbContent;
import cn.small.pig.pojo.TbContentExample;
import cn.small.pig.pojo.TbContentExample.Criteria;
import cn.small.pig.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private TbContentMapper tbContentMapper;
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public PageResult contentFindByPage(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		List<TbContent> list = tbContentMapper.selectByExample(null);
		
		PageInfo pageInfo = new PageInfo(list);


		PageResult pageResult = new PageResult(pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),list);
		return pageResult;
	}

	@Override
	public TbContent contentFindById(long id) {
		return  tbContentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addContent(TbContent newContent) {
		tbContentMapper.insert(newContent);
		//清理缓存
		redisTemplate.boundHashOps("content").delete(newContent.getCategoryId());

	}

	@Override
	public void updateContent(TbContent content) {
		TbContent oldContent = tbContentMapper.selectByPrimaryKey(content.getId());
		
		//删除旧的缓存
		redisTemplate.boundHashOps("content").delete(oldContent.getCategoryId());
		
		tbContentMapper.updateByPrimaryKey(content);
		
		//删除需要更新的缓存
		if(content.getCategoryId() != oldContent.getCategoryId()) {
			redisTemplate.boundHashOps("content").delete(content.getCategoryId());
		}

	}

	@Override
	public void deleteContent(Long[] ids) {
		for(Long id:ids) {
			TbContent tbContent = tbContentMapper.selectByPrimaryKey(id);
			redisTemplate.boundHashOps("content").delete(tbContent.getCategoryId());
			tbContentMapper.deleteByPrimaryKey(id);
		}

	}

	@Override
	public List<TbContent> contentFindByCategoryId(Long categoryId) {
		List<TbContent> list = (List<TbContent>)redisTemplate.boundHashOps("content").get(categoryId);
		if(list==null) {
			System.out.println("log contentFindByCategoryId 更新广告缓存");
			TbContentExample example = new TbContentExample();
			Criteria criteria = example.createCriteria();
			
			criteria.andStatusEqualTo("1");
			criteria.andCategoryIdEqualTo(categoryId);
			example.setOrderByClause("sort_order");
			list = tbContentMapper.selectByExample(example);
			redisTemplate.boundHashOps("content").put(categoryId, list);
		}
		return list;
	}
	

}
