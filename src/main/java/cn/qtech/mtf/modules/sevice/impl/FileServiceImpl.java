package cn.qtech.mtf.modules.sevice.impl;


import cn.qtech.mtf.common.persistence.utils.FileUtil;
import cn.qtech.mtf.modules.dao.AttachmentMapper;
import cn.qtech.mtf.modules.dto.AttachmentDto;
import cn.qtech.mtf.modules.entity.Attachment;
import cn.qtech.mtf.modules.sevice.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by mtf81 on 2017/2/15.
 */
@Service
public class FileServiceImpl implements FileService {
	public static final String DEFULTIMAGE="defaultIcon.jpeg";
	@Autowired
	private AttachmentMapper attachmentMapper;

	private static Attachment attachment=new Attachment();
	@Override
	// TODO: 2017/2/15 获取图片Service 使用AttachmentMapper获得文件名并得到文件对象 调用FileUtil完成
	public ResponseEntity<byte[]> getFile(String ownerType, Integer targetId) {
		AttachmentDto attachmentDto=new AttachmentDto();
		attachmentDto.setOwnerId(targetId);
		attachmentDto.setOwnerType(ownerType);
		Attachment attachment=attachmentMapper.selectByTypeId(attachmentDto);
		try {
		if(attachment!=null){

				File file = new File(FileUtil.DEFAULTDIR,attachment.getAttName());
				return FileUtil.download(attachment.getAttOrigin(), file);

		}else {

			File file = new File(FileUtil.DEFAULTDIR,DEFULTIMAGE);
			return FileUtil.download(DEFULTIMAGE, file);
		}
		}catch (IOException e){
			e.printStackTrace();
		}
		return  null;
	}

	@Override
	public void saveFile(String ownerType, Integer targetId, MultipartFile file) {
		AttachmentDto attachmentDto=new AttachmentDto();
		attachmentDto.setOwnerId(targetId);
		attachmentDto.setOwnerType(ownerType);
		Attachment attachment1=attachmentMapper.selectByTypeId(attachmentDto);
		if(attachment1!=null) {
			attachmentMapper.deleteByPrimaryKey(attachment1.getId());
		}
		attachment.setAttOrigin(file.getOriginalFilename());
		attachment.setOwnerType(ownerType);
		attachment.setOwnerId(targetId);
		attachment.setAttName(FileUtil.saveFile(file));
//		System.out.println(attachment.getAttName());
		attachmentMapper.insert(attachment);

	}
}
