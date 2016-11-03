package com.cqut.controller.upload;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cqut.entity.systemFile.SystemFile;
import com.cqut.service.systemFile.SystemFileService;
import com.cqut.tool.json.JsonTool;
import com.cqut.tool.util.EntityIDFactory;
import com.cqut.tool.util.FileTool;
import com.cqut.tool.util.PropertiesTool;

@Controller
@RequestMapping("/controller")
public class FileController {

	@Resource(name = "systemFileService")
	SystemFileService service;

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
		
		//如果上传目录不存在，则创建
		File parent = new File(imgPath);
		if (!parent.exists()) {
			parent.mkdirs();
		}
		
		return upload(request, response, imgPath,imgRoute);
	}

	@RequestMapping(value = "/uploadFile" , headers=("content-type=multipart/*"),method=RequestMethod.POST)
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest request,
			HttpServletResponse response) {

		//如果上传目录不存在，则创建
		File parent = new File(filePath);
		if (!parent.exists()) {
			parent.mkdirs();
		}
		
		return upload(request, response, filePath,fileRoute);
	}
	
	
	private String upload(MultipartHttpServletRequest request,
			HttpServletResponse response,String path,String route) {
		
		// 1. build an iterator
				Iterator<String> itr = request.getFileNames();
				
				List<FileMeta> result = new ArrayList<FileMeta>();
				
				// 2. get each file
				while (itr.hasNext()) {
					// 2.1 get next MultipartFile
					MultipartFile mpf = request.getFile(itr.next());
					if (!mpf.isEmpty()) {
						//得到文件名
						String originalFilename = mpf.getOriginalFilename();
						
						System.out.println("文件原名: " + originalFilename);
						System.out.println("文件名称: " + mpf.getName());
						System.out.println("文件长度: " + mpf.getSize());
						System.out.println("文件类型: " + mpf.getContentType());
						System.out.println("path:===================="+path);
						try {
							
							String fileID = EntityIDFactory.createId();
							String fileName = "";
							
							if (originalFilename.lastIndexOf(".") >= 0) {	//文件名包括后缀，则FileName以FileID加后缀
								fileName = fileID
										+ originalFilename.substring(originalFilename
												.lastIndexOf("."));
							} else {
								fileName = fileID;
							}

							//文件上传
							mpf.transferTo(new File(path, fileName));
							
							CompressImage compressimage = new CompressImage();
				        	compressimage.setInputDirection(path);
				        	compressimage.setAllInputDirection( path + fileName );
				        	compressimage.setFile(new java.io.File( path + fileName ));
				        	compressimage.setInputFileName(fileName);
				        	compressimage.setOutputDirection(path);
				        	compressimage.setOutputFileName(fileName);
				        	compressimage.setOutputWidth(360);
				        	compressimage.setOutputHeight(200);
				        	compressimage.compressPic();


							//创建systemFile
							SystemFile file = new SystemFile();
							file.setFileID(fileID);

							file.setFileName(fileName);
							file.setFileSize(mpf.getSize());
							file.setFileType(mpf.getContentType());
							Date  date=new Date();
							SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					  		String dat=sdf.format(date);  
					  		Date datee=null;
							try {
								datee = sdf.parse(dat);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							file.setCreatedTime(datee);
							//file.setORIGINALNAME(originalFilename);	//保留原始名

							file.setFilePath(path + "\\" + fileName);

							service.save(file);

						
							FileMeta meta = new FileMeta();

							meta.setFileName(originalFilename);
							meta.setFileID(file.getFileID());
							meta.setFilePath(FileTool.getImgRoute(fileName,route));

							//返回Json
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
	
	
	 /**
     * 文件下载
     * 
     * @param fileID 
	 * @throws UnsupportedEncodingException 
     * @throws IOException
     */
    @RequestMapping(value = "/downFile")
    public ResponseEntity<byte[]> downFile(String fileID) throws UnsupportedEncodingException  {
 
    	HttpHeaders headers = new HttpHeaders();  
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
        
        SystemFile systemFile = service.getSystemFileByID(fileID);
        
        //String f = new String(systemFile.getORIGINALNAME().getBytes("utf-8"),"iso-8859-1");
        String f = new String(systemFile.getFileName().getBytes("utf-8"),"iso-8859-1");
        
        //下载名
        headers.setContentDispositionFormData("attachment",f);  
        
        File file = new File(FileTool.getDownPath(systemFile.getFileName()));  
        
        byte[] bytes = null;
		try {
			bytes = FileUtils.readFileToByteArray(file);
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}  
		
		if(bytes == null){
			return null;
		}
		
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);  
    }
	
	/*@RequestMapping("/downFile")  
	 *方法过于原始，使用j2ee原始接口HttpServletResponse，并不友好
	public void download(HttpServletResponse res) throws IOException {  
	    OutputStream os = res.getOutputStream();  
	    try {  
	        res.reset();  
	        String f = new String("涔涔".getBytes("gb2312"),  
                    "iso-8859-1");
	        res.setHeader("Content-Disposition", "attachment;filename="+f+".txt");  
	        res.setContentType("application/octet-stream; charset=utf-8");  
	        File file = new File("D:/123.txt"); 
	        
	        os.write(FileUtils.readFileToByteArray(file));  
	        os.flush();  
	    } finally {  
	        if (os != null) {  
	            os.close();  
	        }  
	    }  
	}  */
}