package org.cw.midc.service;

import java.io.IOException;

import org.cw.midc.MidcApplication;
import org.cw.midc.model.FileInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.lingala.zip4j.exception.ZipException;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringApplicationConfiguration(classes = MidcApplication.class)
public class ParseDicomServiceTest {

	@Autowired
	private LoadDicomFileService parseDicomService;
	
	@Test
	public void parseOneDicomFileTest()
	{
		FileInfo fi = new FileInfo();
		fi.setFilePath("/3214/2C5E5C5BCBCF4FD886D8C58B15D79722");
		fi.setMediaId("BF8CA511AAB94043ADC48DD29E830118");
		fi.setUserId("123321");
		try {
			parseDicomService.loadDicomFile2DB(fi);;
			System.out.println("ok.");
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
