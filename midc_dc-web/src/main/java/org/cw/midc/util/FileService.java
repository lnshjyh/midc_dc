package org.cw.midc.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;

@Service
public class FileService {

	@Value("${midc.zip.tempdir}")
	private String zipTempDir;

	public File unzipOneFile(String src, String dest) throws ZipException {
		ZipFile zipFile = new ZipFile(src);
		List<FileHeader> fileHeaderList = zipFile.getFileHeaders();
		String fileName = fileHeaderList.get(0).getFileName();
		zipFile.extractFile(fileName, dest);
		File resultFile = new File(dest + "/" + fileName);
		return resultFile;
	}

	public File unzipOneFile(String src) throws ZipException {
		return unzipOneFile(src, zipTempDir);
	}

	// public static File unzipOneFileToStream(String src) throws ZipException
	// {
	// ZipFile zipFile = new ZipFile(src);
	// List<FileHeader> fileHeaderList = zipFile.getFileHeaders();
	// FileHeader fileHeader = fileHeaderList.get(0);
	// ZipInputStream is = zipFile.getInputStream(fileHeader);
	// OutputStream os = new FileOutputStream(outFile);
	// return resultFile;
	// }
}
