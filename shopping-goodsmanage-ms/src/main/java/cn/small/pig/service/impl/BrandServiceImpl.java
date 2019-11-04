package cn.small.pig.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.small.pig.entity.OperateResult;
import cn.small.pig.entity.PageResult;
import cn.small.pig.mapper.TbBrandMapper;
import cn.small.pig.pojo.TbBrand;
import cn.small.pig.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private TbBrandMapper tbBrandMapper;
	@Override
	public PageResult brandFindByPage(int pageNo, int pageSize) {

		PageHelper.startPage(pageNo,pageSize);
		List<TbBrand> brandList = tbBrandMapper.selectByExample(null);
		
		PageInfo pageInfo = new PageInfo(brandList);


		PageResult pageResult = new PageResult(pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getPageSize(),brandList);
		return pageResult;
	}
	
	@Override
	public void addBrand(TbBrand newBrand) {
		tbBrandMapper.insert(newBrand);
		return ;
	}

	@Override
	public void deleteBrand(Long[] ids) {
		for(Long id:ids) {
			tbBrandMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public void updateBrand(TbBrand brand) {
		tbBrandMapper.updateByPrimaryKey(brand);
		
	}

	@Override
	public TbBrand brandFindById(long id) {
		return  tbBrandMapper.selectByPrimaryKey(id);
	}

	
}
