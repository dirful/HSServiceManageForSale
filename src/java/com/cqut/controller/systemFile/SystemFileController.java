package com.cqut.controller.systemFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cqut.controller.upload.CompressImage;
import com.cqut.controller.upload.FileMeta;
import com.cqut.entity.systemFile.SystemFile;
import com.cqut.service.systemFile.ISystemFileService;
import com.cqut.tool.json.JsonTool;
import com.cqut.tool.util.BeanUtil;
import com.cqut.tool.util.EntityIDFactory;
import com.cqut.tool.util.FileTool;
import com.cqut.tool.util.PropertiesTool;

@Controller
@RequestMapping("/systemFileController")
public class SystemFileController {

	@Resource(name = "systemFileService")
	ISystemFileService service;

	/*
	 *  * wxl 上传头像
	 */
	@RequestMapping("/upload_1")
	@ResponseBody
	public String uploadImg_1(
			@RequestParam(value = "file", required = false) MultipartFile file) {
		String ID = BeanUtil.createId();
		String basePath = PropertiesTool.getSystemPram("imgPath");
		Map<String, Object> map = new HashMap<String, Object>();
		String picName = ID + ".jpg";
		File targetFile = new File(basePath + "//" + picName);
		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String path = FileTool.getImgRoute(picName);
		map.put("ID", ID);
		map.put("path", path);
		return JSONObject.fromObject(map).toString();
	}

	/*
	 * wxl上传服务消息图片
	 */
	LinkedList<FileMeta> files = new LinkedList<FileMeta>();
	FileMeta fileMeta = null;

	String imgPath = PropertiesTool.getSystemPram("imgPath");
	String filePath = PropertiesTool.getSystemPram("filePath");

	static String imgRoute = PropertiesTool.getSystemPram("imgRoute");
	static String fileRoute = PropertiesTool.getSystemPram("fileRoute");

	@RequestMapping(value = "/uploadImg")
	@ResponseBody
	public String uploadImg(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("访问了上传图片的方法");

		// 如果上传目录不存在，则创建
		File parent = new File(imgPath);
		if (!parent.exists()) {
			parent.mkdirs();
		}

		return upload(request, response, imgPath, imgRoute);
	}

	/**
	 * chenyubo 上传项目信息图片
	 */
	@RequestMapping(value = "/uploadProjectImg")
	@ResponseBody
	public String uploadProjectImg(MultipartHttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("访问了上传图片的方法");

		// 如果上传目录不存在，则创建
		File parent = new File(imgPath);
		if (!parent.exists()) {
			parent.mkdirs();
		}

		return upload(request, response, imgPath, imgRoute);
	}

	
	
	private String upload(MultipartHttpServletRequest request,
			HttpServletResponse response, String path, String route) {

		// 1. build an iterator
		Iterator<String> itr = request.getFileNames();

		List<FileMeta> result = new ArrayList<FileMeta>();

		// 2. get each file
		while (itr.hasNext()) {
			// 2.1 get next MultipartFile
			MultipartFile mpf = request.getFile(itr.next());
			if (!mpf.isEmpty()) {
				// 得到文件名
				String originalFilename = mpf.getOriginalFilename();

				System.out.println("文件原名: " + originalFilename);
				System.out.println("文件名称: " + mpf.getName());
				System.out.println("文件长度: " + mpf.getSize());
				System.out.println("文件类型: " + mpf.getContentType());
				System.out.println("path:====================" + path);
				try {

					String fileID = EntityIDFactory.createId();
					String fileName = "";

					if (originalFilename.lastIndexOf(".") >= 0) { // 文件名包括后缀，则FileName以FileID加后缀
						fileName = fileID
								+ originalFilename.substring(originalFilename
										.lastIndexOf("."));
					} else {
						fileName = fileID;
					}

					// 文件上传
					mpf.transferTo(new File(path, fileName));

					CompressImage compressimage = new CompressImage();
					compressimage.setInputDirection(path);
					compressimage.setAllInputDirection(path + fileName);
					compressimage.setFile(new java.io.File(path + fileName));
					compressimage.setInputFileName(fileName);
					compressimage.setOutputDirection(path);
					compressimage.setOutputFileName(fileName);
//					compressimage.setOutputWidth(360);
//					compressimage.setOutputHeight(200);
					compressimage.compressPic();

					// 创建systemFile
					SystemFile file = new SystemFile();
					file.setFileID(fileID);

					file.setFileName(fileName);
					file.setFileSize(mpf.getSize());
					file.setFileType(mpf.getContentType());
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String dat = sdf.format(date);
					Date datee = null;
					try {
						datee = sdf.parse(dat);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					file.setCreatedTime(datee);
					// file.setORIGINALNAME(originalFilename); //保留原始名

					file.setFilePath(path + "\\" + fileName);

					service.save(file);

					FileMeta meta = new FileMeta();

					meta.setFileName(originalFilename);
					meta.setFileID(file.getFileID());
					meta.setFilePath(FileTool.getImgRoute(fileName, route));

					// 返回Json
					result.add(meta);

				} catch (IOException e) {
					System.out.println("文件[" + mpf.getOriginalFilename()
							+ "]上传失败,堆栈轨迹如下");
					e.printStackTrace();
				}
			}

		}

		return JsonTool.toJsonList(result, true);
	}
	//wxl 删除图片
		@RequestMapping("/deletePictureByID")
		@ResponseBody
		public String deletePictureByID(String fileID) throws ParseException {
			System.out.println("fileID"+fileID);
			return service.deletePictureByID(fileID) == 1 ? "true" : "false";
		}
	
}
