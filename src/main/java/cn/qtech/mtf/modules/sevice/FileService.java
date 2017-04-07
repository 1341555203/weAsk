package cn.qtech.mtf.modules.sevice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by mtf81 on 2017/2/15.
 */
public interface FileService {
	ResponseEntity<byte []> getFile(String ownerType, Integer targetId);
	void  saveFile(String ownerType, Integer targetId, MultipartFile file);
}
