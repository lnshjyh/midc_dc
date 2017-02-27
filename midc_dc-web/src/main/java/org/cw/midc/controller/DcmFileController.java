package org.cw.midc.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.cw.midc.service.DicomFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * Dicom文件上传及下载
 * @author cloud
 *
 */

@RestController
@Scope("prototype")
public class DcmFileController {

	private static final Logger log = LoggerFactory.getLogger(DcmFileController.class);
	
	@Autowired
	private DicomFileService dicomFileService;
	
	/**
	 * 上传文件
	 * @param userId
	 * @param studyInfoId
	 * @param file
	 */
	@RequestMapping(value="/dicomfile", consumes = "multipart/form-data", method = RequestMethod.POST)
	public void saveFile(@RequestParam(value="userId") String userId,
			@RequestParam(value="studyInfoId") String studyInfoId,
			@RequestParam("file") MultipartFile file)
	{
		log.debug("file name is {}", file.getOriginalFilename());
		log.debug("studyInfoIdis {}", studyInfoId);
		log.debug("userId is {}", userId);
		dicomFileService.saveFileAndGenerateParserTask(file, userId, studyInfoId);
	}
	
	/**
	 * 获取文件
	 * @param fileId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/dicomfile/{fileId}", method = RequestMethod.GET)
	public void getFile(@PathVariable("fileId")String fileId, HttpServletResponse response) throws Exception
	{
		File file = dicomFileService.getFile(fileId);
		InputStream is = new FileInputStream(file);
		IOUtils.copy(is, response.getOutputStream());
		response.flushBuffer();
	}
}
