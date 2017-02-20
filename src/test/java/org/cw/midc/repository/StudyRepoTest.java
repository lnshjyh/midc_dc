package org.cw.midc.repository;

import java.util.Set;

import org.cw.midc.MidcApplication;
import org.cw.midc.model.pacs.Series;
import org.cw.midc.model.pacs.Study;
import org.cw.midc.repository.pacs.StudyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MidcApplication.class)
public class StudyRepoTest {
	
	@Autowired
	private StudyRepository studyRepository;

	@Test
	public void testStudySave()
	{
		System.out.println("ok");
		Study st = new Study();
		st.setStudyUniqueId("123456");
//		Series se = new Series();
//		se.setSeriesUniqueId("5678");
//		st.addSeries(se);
		studyRepository.save(st);
		System.out.println("ok");
	}
	
//	@Test
	public void testStudySave2()
	{
		Study st = studyRepository.findOne("123456");
		Set<Series> ses = st.getSerieses();
		ses.size();
//		Series se = new Series();
//		se.setSeriesUniqueId("567890");
//		st.addSeries(se);
//		studyRepository.save(st);
	}
}
