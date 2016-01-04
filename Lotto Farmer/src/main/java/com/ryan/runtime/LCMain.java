package com.ryan.runtime;

import java.io.IOException;
import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ryan.model.DrawType;
import com.ryan.service.LottoResultService;
import com.ryan.service.scraper.PCSOScraperService;

public class LCMain {	

	public static void main(String[] args) throws IOException {
		
		PCSOScraperService ultraLotto = new PCSOScraperService(new URL("http://www.philippinepcsolotto.com/6-58-lotto-result-summary"));
		ultraLotto.setDraw_type(DrawType.PHLPCSOUL);
		ultraLotto.runScraper();
		PCSOScraperService grandLotto = new PCSOScraperService(new URL("http://www.philippinepcsolotto.com/6-55-lotto-result-summary"));
		grandLotto.setDraw_type(DrawType.PHLPCSOGL);
		grandLotto.runScraper();
		PCSOScraperService superLotto = new PCSOScraperService(new URL("http://www.philippinepcsolotto.com/6-49-lotto-result-summary"));
		superLotto.setDraw_type(DrawType.PHLPCSOSL);
		superLotto.runScraper();
		PCSOScraperService megaLotto = new PCSOScraperService(new URL("http://www.philippinepcsolotto.com/6-45-lotto-result-summary"));
		megaLotto.setDraw_type(DrawType.PHLPCSOML);
		megaLotto.runScraper();
		PCSOScraperService lotto = new PCSOScraperService(new URL("http://www.philippinepcsolotto.com/6-42-lotto-result-summary"));
		megaLotto.setDraw_type(DrawType.PHLPCSOL);
		megaLotto.runScraper();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		LottoResultService lrService =  (LottoResultService) context.getBean("LottoResultServiceImpl");
		lrService.insertRecords(ultraLotto.getResults());
		lrService.insertRecords(grandLotto.getResults());
		lrService.insertRecords(superLotto.getResults());
		lrService.insertRecords(megaLotto.getResults());
		lrService.insertRecords(lotto.getResults());

		//System.out.println(lrDao.retrieveByDrawDateAndDrawType(new GregorianCalendar(2015, 05, 13).getTime(), DrawType.PHLPCSOGL));
		/*for(LottoResult lr : lrDao.retrieveByDrawDateAndDrawType(new GregorianCalendar(2015, 05, 01).getTime(), new GregorianCalendar(2015, 05, 13).getTime(), DrawType.PHLPCSOGL)) {
			System.out.println(lr);
		}*/

		/*for(LottoResult lss : lrDao.retrieveAllByDrawType(DrawType.PHLPCSOGL)) {
			System.out.println(lss);
		}*/
	}
}

