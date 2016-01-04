package com.ryan.runtime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Demo {
	public static void main(String[] args) {
		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		Document doc = Jsoup.parse(html);
		Element link = doc.select("a").first();

		String text = doc.body().text(); // "An example link"
		System.out.println(text);
		String linkHref = link.attr("href"); // "http://example.com/"
		System.out.println(linkHref);
		String linkText = link.text(); // "example""
		System.out.println(linkText);

		String linkOuterH = link.outerHtml(); 
		System.out.println(linkOuterH);
		    // "<a href="http://example.com"><b>example</b></a>"
		String linkInnerH = link.html(); // "<b>example</b>"
		System.out.println(linkInnerH);
		
		
	}
}
