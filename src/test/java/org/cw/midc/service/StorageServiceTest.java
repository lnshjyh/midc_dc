package org.cw.midc.service;

import org.cw.midc.MidcApplication;
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
public class StorageServiceTest {

	@Autowired
	private StorageService storageService;
	
	@Autowired
	private MediaRepository mediaRepository;
	
	
	//@Test
	public void testTest()
	{
		String path = storageService.getCurrentBaseStoragePath();
		System.out.println("path is {}"+ path);
	}
	
//	@Test
	public void getCurrentMediaTest()
	{
		MediaInfo mi = storageService.getCurrentMedia();
		System.out.println("path is {}"+ mi.getPath());
	}
	
	@Test
	public void getMediaInfoTest()
	{
		String name = "20170125";
		MediaInfo mi = mediaRepository.findByName(name);
		System.out.println("path is {}"+ mi.getPath());
		
		MediaInfo mi2 = mediaRepository.findByName(name);
		System.out.println("path is {}"+ mi2.getPath());
		
		MediaInfo mi3 = mediaRepository.findByName(name);
		System.out.println("path is {}"+ mi3.getPath());
	}
}
