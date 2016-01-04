package com.ryan.service.scraper;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ryan.exception.InvalidLottoResultException;
import com.ryan.model.DrawType;
import com.ryan.model.LottoResult;
import com.ryan.service.ScrapeData;
import com.ryan.service.ScraperService;

public class PCSOScraperService extends ScrapeData implements ScraperService {
	private List<LottoResult> results = new ArrayList<LottoResult>();
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("MMM dd, yyyy");
	private String raw_data;
	private String raw_draw_date;
	private URL url = null;
	private Document doc = null;


	public PCSOScraperService() {
		try {
			this.url = new URL("http://www.philippinepcsolotto.com/6-55-lotto-result-summary");			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PCSOScraperService(URL url) {		
		try {
			doc = Jsoup.connect(url.toString()).get();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void runScraper() {

		Elements newsHeadlines = doc.select("li");

		LottoResult result = null;
		ScrapeData extract = null;
		for(Element element : newsHeadlines) {
			if(!element.hasAttr("id") & !element.hasAttr("class")) {
				if(element.select("a").toString().length() == 0) {

					String[] s = element.text().split("-", 2);

					this.raw_draw_date = s[0];
					this.raw_data = s[1];


					try {
						result = new LottoResult();
						this.extract();
						result.setRaw_data(this);
						results.add(result);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						result = null;
						extract = null;
					}
				}
			}
		}
	}

	public List<LottoResult> getResults() {
		return results;
	}

	public void setResults(List<LottoResult> results) {
		this.results = results;
	}

	private void extract() throws InvalidLottoResultException {
		try {
			super.draw_date = FORMATTER.parse(this.raw_draw_date);
		} catch(ParseException ex) {
			throw new InvalidLottoResultException(ex.getMessage());
		}

		String[] data = null;

		try {
			data = this.raw_data.split("-");
		} catch(Exception ex) {
			throw new InvalidLottoResultException("Raw Data split is not valid.");
		}

		if(data.length < 6) {
			throw new InvalidLottoResultException("Split data must be 6 digits.");
		}

		int position = 0;
		for(String s : data) {
			position += 1;
			try {
				super.draws.put(position, Integer.parseInt(s.trim()));
			} catch (Exception ex) {
				throw new InvalidLottoResultException("Parse error at position ["+ position +"], value ["+ s +"]");
			} 
		}
	}
}
