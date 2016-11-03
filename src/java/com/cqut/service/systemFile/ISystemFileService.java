package com.cqut.service.systemFile;

import java.util.List;
import java.util.Map;

import com.cqut.entity.systemFile.SystemFile;


public interface ISystemFileService {
	public SystemFile getSystemFileByID(String ID);

	List<String> getPicPathByIDs(String[] IDs);

	boolean saveEntity(SystemFile file);

	List<Map<String, Object>> getQRCode(String QRCode);

	 int delate(String iD);

	void save(SystemFile file);
	public int deletePictureByID(String fileID);
	
}
