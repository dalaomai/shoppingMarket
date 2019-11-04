package cn.small.pig.pojogroup;

import java.util.List;

import cn.small.pig.pojo.TbSpecification;
import cn.small.pig.pojo.TbSpecificationOption;

public class Specification {
	private TbSpecification specification;
	private List<TbSpecificationOption> specificationOptionList;
	
	public TbSpecification getSpecification() {
		return specification;
	}
	public void setSpecification(TbSpecification specification) {
		this.specification = specification;
	}
	public List<TbSpecificationOption> getSpecificationOptionList() {
		return specificationOptionList;
	}
	public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
		this.specificationOptionList = specificationOptionList;
	}
	
	
}
