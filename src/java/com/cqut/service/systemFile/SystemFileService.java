package com.cqut.service.systemFile;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cqut.service.search.SearchService;
import com.cqut.tool.util.EntityIDFactory;
import com.cqut.tool.util.FileTool;
import com.cqut.tool.util.PropertiesTool;

import  com.cqut.dao.systemFile.SystemFileDao;
import  com.cqut.entity.systemFile.SystemFile;

@Service
public class SystemFileService extends SearchService implements ISystemFileService{
	
	@Resource(name="systemFileDao")
	SystemFileDao dao ;
	
	@Override
	public int delate(String iD) {
		String[] properties = {
				"train.trainPic AS trainPic",
			    };
		String baseEntity = "train";
		String joinEntity =null;
		String[] foreignEntitys =null;
		String condition = "train.trainID = '"+iD+"'";
		List<Map<String, Object>> list = this.originalSearchForeign(properties,baseEntity,joinEntity,foreignEntitys,condition,false);
		String TrianPIC  = list.get(0).get("trainPic").toString();
		String condition2 = "systemfile.fileID ='" + TrianPIC +"'";
		return dao.deleteByCondition(condition2);
	}
	@Override
	public String getBaseEntityName() {
		return "systemFile";
	}

	@Override
	public String getBasePrimaryKey() {
		return "systemFile.fileID";
	}
	@Override
	public void save(SystemFile file) {
		// TODO Auto-generated method stub
		System.out.println(dao.save(file));
	}

	public SystemFile getSystemFileByID(String ID) {
		// TODO Auto-generated method stub
		System.out.println(ID);
		return  dao.getByID(ID);
	}
	
	@Override
	public boolean saveEntity(SystemFile file) {
		
		return dao.save(file) == 1 ? true : false;
	}
	
	@Override
	public List<String> getPicPathByIDs(String[] IDs){
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < IDs.length; i ++){
			String name = dao.getByID(IDs[i]).getFileName();
			if(name != null && !"".equals(name)){
				name = PropertiesTool.getSystemPram("imgPath") + name;
			}else{
				name = PropertiesTool.getSystemPram("BASEURL") + "img/article/defaultPhoto.png";
			}
			list.add(name);
		}
		return list;
	}
	@Override
	public List<Map<String, Object>> getQRCode(String QRCode){
		String[] properties=new String[]{
				"systemfile.fileID AS fileID",
				"systemfile.fileName AS fileName"
				}; 
		String condition = "systemfile.fileID ='"+QRCode+"'";
			List<Map<String, Object>> list = this.originalSearchForeign(properties, "systemfile",null, null, condition, false);
			for (Map<String, Object> element : list) {
				String pic = (String) element.get("fileName");
				element.put("fileName", FileTool.getImgRoute(pic));
			}
			
			return list;
			}
	@Override
	public int deletePictureByID(String fileID) {
		return dao.deleteByID(fileID);
	}


}
