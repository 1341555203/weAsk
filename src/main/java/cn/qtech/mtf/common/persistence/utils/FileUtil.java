package cn.qtech.mtf.common.persistence.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/*
文件操作类
文件名转换
文件下载
文件上传
 */
public class FileUtil {
	public static final String DEFAULTFILEPATH="d:/files";
	public static final File DEFAULTDIR=new File(DEFAULTFILEPATH);

	public static  ResponseEntity<byte[]> download(String fileName,File file) throws IOException{
		String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", dfileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}
	/*
	存储文件返回新文件名
	 */
	public static String saveFile(MultipartFile multipartFile){

		String newName = EncodeUtil.EncodeFileName(multipartFile.getOriginalFilename());
		try {
			File file = new File(DEFAULTDIR, "temp");
			multipartFile.transferTo(file);
			if (!DEFAULTDIR.exists()) {
				DEFAULTDIR.mkdirs();
			}
			File newFile = new File(DEFAULTDIR, newName);
			file.renameTo(newFile);
		}catch (IOException e){
			e.printStackTrace();
		}
		return newName;
	}
}
