package cn.small.pig.service;
import java.util.List;

import cn.small.pig.entity.OperateResult;
import cn.small.pig.entity.PageResult;
import cn.small.pig.pojo.TbBrand;

public interface BrandService {
	public PageResult brandFindByPage(int pageNo,int pageSize);
	public TbBrand brandFindById(long id);
	public void addBrand(TbBrand newBrand);
	public void deleteBrand(Long[] ids);
	public void updateBrand(TbBrand brand);
}
