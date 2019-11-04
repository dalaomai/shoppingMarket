package cn.small.pig.controller;

import java.util.List;

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
import cn.small.pig.service.BrandService;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@RequestMapping("/brandFindByPage")
	public PageResult brandFindByPage(int pageNo,int pageSize){
		System.out.println("log brandFindByPage || pageNo : "+ pageNo + " pageSize: " + pageSize);
		return brandService.brandFindByPage(pageNo, pageSize);
	}
	
	@PostMapping("/addBrand")
	public OperateResult addBrand(@RequestBody TbBrand newBrand) {
		System.out.println("log addBrand || " + newBrand.toString());
		try {
			brandService.addBrand(newBrand);
			return new OperateResult(true,"add new brand success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@GetMapping("/deleteBrand")
	public OperateResult deleteBrand(Long[] ids) {
		System.out.println("log deleteBrand || " + ids.toString());
		try {
			brandService.deleteBrand(ids);
			return new OperateResult(true,"delete brands success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@GetMapping("/brandFindById")
	public TbBrand brandFindById(long id) {
		System.out.println("log brandFindById || id:" + id);
		return brandService.brandFindById(id);
	}
	
	@PostMapping("/updateBrand")
	public OperateResult updateBrand(@RequestBody TbBrand brand) {
		System.out.println("log updateBrand || " + brand.toString());
		try {
			brandService.updateBrand(brand);
			return new OperateResult(true,"update brand success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}

}
