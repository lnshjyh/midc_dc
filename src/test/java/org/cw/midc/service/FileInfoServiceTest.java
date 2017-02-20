package org.cw.midc.service;

import java.util.Arrays;
import java.util.List;

import org.cw.midc.MidcApplication;
import org.cw.midc.model.FileInfo;
import org.cw.midc.model.storage.MediaInfo;
import org.cw.midc.model.storage.StorageInfo;
import org.cw.midc.repository.storage.MediaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringApplicationConfiguration(classes = MidcApplication.class)
public class FileInfoServiceTest {

	@Autowired
	private DicomFileService dicomFileService;

	
//	@Test
	public void testTest()
	{
		List<FileInfo> result = dicomFileService.getUnHandledFileInfoByBatch(2);
//		result.forEach(action);
		System.out.println("ok");
	}
	
//	@Test
	public void onParseFileSuccessedTest()
	{
		FileInfo fi = new FileInfo();
		fi.setId("FB85215C239B463F94CF74FCD317AB82");
		dicomFileService.onParseFileSucceeded(fi);
		System.out.println("ok");
	}
	
//	@Test
	public void onParseFileFailedTest()
	{
		FileInfo fi = new FileInfo();
		fi.setId("775EAE6070F2490B843AA668A315FD5F");
		dicomFileService.onParseFileFailed(fi);;
		System.out.println("ok");
	}
	
	@Test
	public void LambdaTest()
	{
		final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
		friends.forEach((name) -> System.out.println(name));
	}

}
