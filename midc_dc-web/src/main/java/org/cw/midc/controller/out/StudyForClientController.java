package org.cw.midc.controller.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.cw.midc.Response;
import org.cw.midc.dto.StudyQueryDto;
import org.cw.midc.service.DicomFileService;
import org.cw.midc.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/out")
public class StudyForClientController {
	
	@Autowired
	private DicomFileService dicomFileService;
	
	@Autowired
	private StudyService studyService;

	/**
	 * 获取文件
	 * @param fileId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/dicomfile/{fileId}", method = RequestMethod.GET)
	public void getDicomFile(@PathVariable("fileId")String fileId, HttpServletResponse response) throws Exception
	{
		File file = dicomFileService.getFile(fileId);
		InputStream is = new FileInputStream(file);
		IOUtils.copy(is, response.getOutputStream());
		response.flushBuffer();
	}
	
	
	@RequestMapping(value = "/study/{studyInfoId}", method = RequestMethod.GET)
	@ResponseBody
	public Response getStudyStructure(@PathVariable("studyInfoId")String studyInfoId) throws Exception
	{
		Response response = new Response();
		List<StudyQueryDto> StudyQueryDtos = studyService.getStudyStruct(studyInfoId);
		response.setData(StudyQueryDtos);
		return response;
		
	}
}
