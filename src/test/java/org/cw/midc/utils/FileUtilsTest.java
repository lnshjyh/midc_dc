package org.cw.midc.utils;

import org.cw.midc.MidcApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.lingala.zip4j.exception.ZipException;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringApplicationConfiguration(classes = MidcApplication.class)
public class FileUtilsTest {

	@Test
	public void unzipTest()
	{
		String src = "F:/dicomsave/20170125/3214/2C5E5C5BCBCF4FD886D8C58B15D79722";
		String dest = "F:/dicomsave/20170125/3214";
		String destFileName = "2C5E5C5BCBCF4FD886D8C58B15D79722.unzipdcm";
//		try {
//			FileUtils.unzip(src, dest);
//		} catch (ZipException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
