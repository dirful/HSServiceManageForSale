package com.cqut.controller.upload;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@Controller
@RequestMapping("/compressImage")
public class CompressImage {
			private File file = null;//需要压缩的图片
			private String inputDirection;//原始图片的路径
			private String allInputDirection;//原始图片的全路径
			private String outputDirection;//输出图片的路径
			private String inputFileName;//原始图片的图片名
			private String outputFileName;//输出图片的路径
			private int outputWidth ;//输出图片的宽度
			private int outputHeight ;//输出图片的高度
			
			public CompressImage(){
				inputDirection = "";
				outputDirection = "";
				inputFileName = "";
				outputFileName = "";
//				outputWidth = 100;
//				outputHeight = 100;
			}

			public File getFile() {
				return file;
			}

			public void setFile(File file) {
				this.file = file;
			}

			public String getInputDirection() {
				return inputDirection;
			}

			public void setInputDirection(String inputDirection) {
				this.inputDirection = inputDirection;
			}

			public String getOutputDirection() {
				return outputDirection;
			}

			public void setOutputDirection(String outputDirection) {
				this.outputDirection = outputDirection;
			}

			public String getInputFileName() {
				return inputFileName;
			}

			public void setInputFileName(String inputFileName) {
				this.inputFileName = inputFileName;
			}

			public String getOutputFileName() {
				return outputFileName;
			}

			public void setOutputFileName(String outputFileName) {
				this.outputFileName = outputFileName;
			}

			public String getAllInputDirection() {
				return allInputDirection;
			}

			public void setAllInputDirection(String allInputDirection) {
				this.allInputDirection = allInputDirection;
			}

			public int getOutputWidth() {
				return outputWidth;
			}

			public void setOutputWidth(int outputWidth) {
				this.outputWidth = outputWidth;
			}

			public int getOutputHeight() {
				return outputHeight;
			}

			public void setOutputHeight(int outputHeight) {
				this.outputHeight = outputHeight;
			}
			
			public long getImageSize(String path){
				file = new File(path);
				return file.length();
			}
			
			public String compressPic(){
				
				try{
					/*
					 * 判断指定路径的图片是否存在
					 * 
					 * */
					/*file = new File(this.getInputDirection()+this.getInputFileName());*/
					file = new File(this.getAllInputDirection());
					if(!file.exists()){
						System.out.println("---------------未找到指定文件------------------");
						return "";
					}
					/*
					 * 获取到该图片
					 * */
					Image img = ImageIO.read(file);
					if(img.getWidth(null)==-1){
						System.out.println("-----------------文件格式不对----------");
						return "no";
					}
					else{
					/*
					 * 得到用户指定的大小
					 * */
						int newWidth = this.getOutputWidth();
						int newHeight = this.getOutputHeight();
					/*
					 * 在内存中创建一张空图
					 * 
					 * */
						BufferedImage tagret = new BufferedImage(newWidth,newHeight,BufferedImage.TYPE_INT_RGB);
					/*
					 * 将原图的信息克隆在新图中
					 * */	
						tagret.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH),0,0,null);
					/*
					 * 通过输出流输出该图片
					 * */	
						File file_save = new File(this.getOutputDirection());
						if(!file_save.exists()){
							file_save.mkdirs();
						}
						String dstName = this.getOutputDirection()+this.getOutputFileName();
						FileOutputStream out = new FileOutputStream(this.getOutputDirection()+this.getOutputFileName());
					/*
					 * 图片的格式转换
					 * */	
						/*JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
						encoder.encode(tagret);*/
						String formatName = dstName.substring(dstName.lastIndexOf(".") + 1);
				        //FileOutputStream out = new FileOutputStream(dstName);
				        //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				        //encoder.encode(dstImage);
				        ImageIO.write(tagret, /*"GIF"*/ formatName /* format desired */ , new File(dstName) /* target */ );
						out.close();
						
						
					}
					
				}catch(Exception e){
					System.out.println(""+e.getMessage());
				}
				return "ok";
			}
}
