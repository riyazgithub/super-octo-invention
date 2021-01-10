package com.year2020;

import java.util.ArrayList;
import java.util.List;

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

interface HtmlParser {
    public List<String> getUrls(String url);
  }

  class htmlParserClass implements HtmlParser {

	public List<String> getUrls(String url){
	  List<String> returnUrls = new ArrayList<String>();
	  returnUrls.add("http://news.yahoo.com");
	  returnUrls.add("http://news.yahoo.com/news");
	  returnUrls.add("http://news.yahoo.com/news/topics/");
	  returnUrls.add("http://news.google.com");
	  returnUrls.add( "http://news.yahoo.com/us");
	  return returnUrls;
	}
  }
class Solution_Feb17 {
  public List<String> crawl(String startUrl, HtmlParser htmlParser) {
	List<String> crawledURLS = new ArrayList<String>();
	String domainName = getDomain(startUrl);
	List<String> urlList = htmlParser.getUrls(startUrl);
	for (String url : urlList) {
	  if(url.contains(domainName)) {
	    crawledURLS.add(url);
	  }
	}
	return crawledURLS;
  }

  public String getDomain(String startUrl){
    String domainName;
    domainName = startUrl.replaceAll("http://","");
	domainName = domainName.replaceAll("https://","");
	domainName = domainName.substring(0,domainName.indexOf('/'));
    return domainName;
  }

  public static void main(String[] args) {
    Solution_Feb17 solutionFeb17 = new Solution_Feb17();
    HtmlParser htmlParser = new htmlParserClass();
	List<String> crawledURLS  = solutionFeb17.crawl("http://news.yahoo.com/news", htmlParser);
	System.out.println("Crawled Urls : "+crawledURLS);

  }
}