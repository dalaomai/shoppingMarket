package cn.small.pig.controller;

import java.io.File;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.small.pig.entity.OperateResult;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class imgUploadController {
	@PostMapping("/imgUpload")
	//@RequestParam("file") 表单式
	public OperateResult imgUpload(MultipartFile file) {
		try {
			String path="C:\\Users\\dalaomai\\Desktop\\YueQianPeiXun\\shopping-parents\\shopping-goodsmanage-ms\\src\\main/resources/img";
			String url = "";
			if(file!=null && file.getSize()>0) {
				file.transferTo(new File(path,file.getOriginalFilename()));
				url = "./static/" + file.getOriginalFilename();
			}else {
				return new OperateResult(false,"文件为空");
			}
			return new OperateResult(true,url);
		}catch(Exception e) {
			e.printStackTrace();
			return new OperateResult(false,"上传失败");
		}
	}
}
