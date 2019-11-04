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
import cn.small.pig.pojo.TbContent;
import cn.small.pig.service.ContentService;


@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class ContentController {
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/contentFindByPage")
	public PageResult contentFindByPage(int pageNo,int pageSize){
		System.out.println("log contentFindByPage || pageNo : "+ pageNo + " pageSize: " + pageSize);
		return contentService.contentFindByPage(pageNo, pageSize);
	}
	
	@PostMapping("/addContent")
	public OperateResult addContent(@RequestBody TbContent newContent) {
		System.out.println("log addContent || " + newContent.toString());
		try {
			contentService.addContent(newContent);
			return new OperateResult(true,"add new content success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@GetMapping("/deleteContent")
	public OperateResult deleteContent(Long[] ids) {
		System.out.println("log deleteContent || " + ids.toString());
		try {
			contentService.deleteContent(ids);
			return new OperateResult(true,"delete contents success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@GetMapping("/contentFindById")
	public TbContent contentFindById(long id) {
		System.out.println("log contentFindById || id:" + id);
		return contentService.contentFindById(id);
	}
	
	@PostMapping("/updateContent")
	public OperateResult updateContent(@RequestBody TbContent content) {
		System.out.println("log updateContent || " + content.toString());
		try {
			contentService.updateContent(content);
			return new OperateResult(true,"update Content success");
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"error");
		}
	}
	
	@GetMapping("/contentFindByCategoryId")
	public List<TbContent> contentFindByCategoryId(long categoryId) {
		System.out.println("log contentFindByCategoryId || id:" + categoryId);
		return contentService.contentFindByCategoryId(categoryId);
	}

}
