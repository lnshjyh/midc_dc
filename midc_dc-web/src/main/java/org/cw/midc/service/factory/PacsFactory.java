package org.cw.midc.service.factory;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.cw.midc.model.FileInfo;
import org.cw.midc.model.pacs.Instance;
import org.cw.midc.model.pacs.Series;
import org.cw.midc.model.pacs.Study;
import org.cw.midc.util.DateUtils;
import org.dcm4che2.data.DicomObject;
import org.dcm4che2.data.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PacsFactory {

	private static final Logger log = LoggerFactory.getLogger(PacsFactory.class);
	
	/**
	 * 创建Study实体
	 * @param dicom
	 * @param fileInfo
	 * @param key
	 * @return
	 */
	public Study createStudyFrom(DicomObject dicom, FileInfo fileInfo, String key)
	{
		//解析字段
		String patientId = dicom.getString(Tag.PatientID);
		String patientSex = dicom.getString(Tag.PatientSex);
		String patientName = dicom.getString(Tag.PatientName);
		String specificCharacterSet = dicom.getString(Tag.SpecificCharacterSet);
		if (patientName != null && "ISO_IR 100".equals(specificCharacterSet)) {
			try {
				patientName = new String(patientName.getBytes("ISO8859_1"), "GBK");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}		
		String patientWeight = dicom.getString(Tag.PatientWeight);
		String patientSize = dicom.getString(Tag.PatientSize);
		String patientAge = dicom.getString(Tag.PatientAge);
		Date patientBirthdate = null;
		try {
			patientBirthdate = dicom.getDate(Tag.PatientBirthDate);
		} catch (Exception e) {
			log.error("dicom.getDate(Tag.PatientBirthDate) fail!");
		}
		String accessNumber = dicom.getString(Tag.AccessionNumber);
		String studyDescription = dicom.getString(Tag.StudyDescription);
		Date studytime =  null, date = null, time = null;
		try {
			date = dicom.getDate(Tag.StudyDate) == null ? (dicom.getDate(Tag.SeriesDate) == null ? 
				   dicom.getDate(Tag.AcquisitionDate) : dicom.getDate(Tag.SeriesDate)) : dicom.getDate(Tag.StudyDate);
			time = dicom.getDate(Tag.StudyTime) == null ? (dicom.getDate(Tag.SeriesTime) == null ? 
				   dicom.getDate(Tag.AcquisitionTime) : dicom.getDate(Tag.SeriesTime)) : dicom.getDate(Tag.StudyTime);
		} catch (Exception e) {
			log.debug("ERROR: getDate failed!");
		}
		if (date != null && time != null)
			studytime = DateUtils.strToDateLong(DateUtils.dateToStr_new1(date) + " " + DateUtils.timeToStr_new1(time));
		String modality = dicom.getString(Tag.Modality);
		String studyInstanceUID = dicom.getString(Tag.StudyInstanceUID);
		String studyId = dicom.getString(Tag.StudyID);
		String otherpatientids = dicom.getString(Tag.OtherPatientIDs);
		String otherpatientname = dicom.getString(Tag.OtherPatientNames);
		
		//生成实体
		Study study = new Study();
		study.setStudyUniqueId(key);
		study.setStudyInstanceUId(studyInstanceUID);
		study.setPatientId(patientId);
		study.setPatientName(patientName);
		study.setPatientSex(patientSex);
		study.setPatientAge(patientAge);
		study.setPatientBirthday(patientBirthdate);
		study.setPatientSize((patientSize == null || "".equals(patientSize)) ? 0 : Float.parseFloat(patientSize));
		study.setPatientWeight((patientWeight == null || "".equals(patientWeight)) ? 0 : Float.parseFloat(patientWeight));
		study.setAccessNo(accessNumber);
		study.setStudyDescription(studyDescription);
		study.setModality(modality);
		study.setStudyId(studyId);
		study.setUserId(fileInfo.getUserId());
		study.setStudyTime(studytime);
		return study;
	}
	
	/**
	 * 创建Series实体
	 * @param dicom
	 * @param fileInfo
	 * @param key
	 * @param studyUniqueID
	 * @return
	 */
	public Series createSeriesFrom(DicomObject dicom, FileInfo fileInfo, String key, String studyUniqueID)
	{
		String seriesInstanceUID = dicom.getString(Tag.SeriesInstanceUID);
		String seriesDescription = dicom.getString(Tag.SeriesDescription);
		String seriesNumber = dicom.getString(Tag.SeriesNumber);
		
		Series series = new Series();
		series.setSeriesUniqueId(key);
		series.setSeriesInstanceUId(seriesInstanceUID);
		series.setSeriesNo(seriesNumber);
		series.setSeriesDescription(seriesDescription);
		series.setStudyUniqueId(studyUniqueID);		
		return series;
	}
	
	/**
	 * 创建Instance实体
	 * @param dicom
	 * @param fileInfo
	 * @param key
	 * @param seriesUniqueID
	 * @return
	 */
	public Instance createInstanceFrom(DicomObject dicom, FileInfo fileInfo, String key, String seriesUniqueID)
	{
		String sopInstanceUID = dicom.getString(Tag.SOPInstanceUID);		
		String instanceNumber = dicom.getString(Tag.InstanceNumber);
		Date acquisitionDateTime = dicom.getDate(Tag.AcquisitionDateTime);
		
		Instance instance = new Instance();
		instance.setInstanceUId(key);
		instance.setSeriesUniqueId(seriesUniqueID);
		instance.setSopInstanceUId(sopInstanceUID);
		instance.setInstanceNumber(instanceNumber);
		instance.setFileId(fileInfo.getId());
		instance.setAcquisitionDateTime(acquisitionDateTime);
		return instance;
	}

}
