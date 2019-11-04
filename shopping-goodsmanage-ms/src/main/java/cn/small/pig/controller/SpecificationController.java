package cn.small.pig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.small.pig.entity.OperateResult;
import cn.small.pig.entity.PageResult;
import cn.small.pig.pojo.TbBrand;
import cn.small.pig.pojo.TbSpecification;
import cn.small.pig.pojogroup.Specification;
import cn.small.pig.service.SpecificationService;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class SpecificationController {
	@Autowired
	private SpecificationService specificationService;
	
	@RequestMapping("/specificationFindByPage")
	public PageResult specificationFindByPage(int pageNo,int pageSize){
		System.out.println("log specificationService || pageNo : "+ pageNo + " pageSize: " + pageSize);
		return specificationService.specificationFindByPage(pageNo, pageSize);
	}
	
	@GetMapping("/specificationFindById")
	public Specification specificationFindById(long id) {
		System.out.println("log specificationFindById || id:" + id);
		return specificationService.specificationFindById(id);
	}
	
	@PostMapping("/addSpecification")
	public OperateResult addBrand(@RequestBody Specification newSpecification) {
		System.out.println("log addSpecification || " + newSpecification.toString());
		try {
			specificationService.addSpecification(newSpecification);
			return new OperateResult(true,"add new Specification success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@PostMapping("/updateSpecification")
	public OperateResult updateSpecification(@RequestBody Specification specification) {
		System.out.println("log updateSpecification || " + specification.toString());
		try {
			specificationService.updateSpecification(specification);
			return new OperateResult(true,"update specification success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@GetMapping("/deleteSpecification")
	public OperateResult deleteSpecification(Long[] ids) {
		System.out.println("log deleteSpecification || " + ids.toString());
		try {
			specificationService.deleteSpecification(ids);
			return new OperateResult(true,"delete success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@RequestMapping("/specificationFindByName")
	public PageResult specificationFindByName(String name,int pageNo,int pageSize){
		System.out.println("log specificationFindByName || name:"+ name +" pageNo : "+ pageNo + " pageSize: " + pageSize);
		return specificationService.specificationFindByName(name,pageNo, pageSize);
	}
}
