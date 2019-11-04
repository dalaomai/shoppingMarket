package cn.small.pig.service;

import cn.small.pig.entity.PageResult;
import cn.small.pig.pojo.TbBrand;
import cn.small.pig.pojo.TbSpecification;
import cn.small.pig.pojogroup.Specification;

public interface SpecificationService {
	public PageResult specificationFindByPage(int pageNo,int pageSize);
	public Specification specificationFindById(long id);
	public void addSpecification(Specification newSpecification);
	public void updateSpecification(Specification specification);
	public void deleteSpecification(Long[] ids);
	public PageResult specificationFindByName(String name,int pageNo,int pageSize);
}
