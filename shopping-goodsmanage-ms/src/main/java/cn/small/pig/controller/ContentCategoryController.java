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
import cn.small.pig.pojo.TbContent;
import cn.small.pig.pojo.TbContentCategory;
import cn.small.pig.service.ContentCategoryService;
import cn.small.pig.service.ContentService;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ContentCategoryController {
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/contentCategoryFindByPage")
	public PageResult contentCategoryFindByPage(int pageNo,int pageSize){
		System.out.println("log brandFindByPage || pageNo : "+ pageNo + " pageSize: " + pageSize);
		return contentCategoryService.contentCategoryFindByPage(pageNo, pageSize);
	}
	
	@PostMapping("/addContentCategory")
	public OperateResult addContentCategory(@RequestBody TbContentCategory newContentCategory) {
		System.out.println("log addContentCategory || " + newContentCategory.toString());
		try {
			contentCategoryService.addContentCategory(newContentCategory);
			return new OperateResult(true,"add new content success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@GetMapping("/deleteContentCategory")
	public OperateResult deleteContentCategory(Long[] ids) {
		System.out.println("log deleteContentCategory || " + ids.toString());
		try {
			contentCategoryService.deleteContentCategory(ids);
			return new OperateResult(true,"delete contentCategorys success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@GetMapping("/contentCategoryFindById")
	public TbContentCategory contentCategoryFindById(long id) {
		System.out.println("log contentCategoryFindById || id:" + id);
		return contentCategoryService.contentCategoryFindById(id);
	}
	
	@PostMapping("/updateContentCategory")
	public OperateResult updateContentCategory(@RequestBody TbContentCategory contentCategory) {
		System.out.println("log updateContentCategory || " + contentCategory.toString());
		try {
			contentCategoryService.updateContentCategory(contentCategory);
			return new OperateResult(true,"update contentCategory success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@RequestMapping("/contentCategoryFindByName")
	public PageResult contentCategoryFindByName(String name,int pageNo,int pageSize){
		System.out.println("log contentCategoryFindByName || name:"+ name +" pageNo : "+ pageNo + " pageSize: " + pageSize);
		return contentCategoryService.contentCategoryFindByName(name,pageNo, pageSize);
	}
}
