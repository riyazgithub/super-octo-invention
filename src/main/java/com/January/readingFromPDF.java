package com.January;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class readingFromPDF {

  public static final String[] FILES = {
	  "/Users/rafthab/Downloads/Robinhood/Dec2019.pdf",
	  "/Users/rafthab/Downloads/Robinhood/Jan2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/Feb2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/Mar2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/Jun2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/Jul2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/Aug2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/SEP2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/Oct2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/Nov2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/Dec2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/APR2020.pdf",
	  "/Users/rafthab/Downloads/Robinhood/MAY2020.pdf"
  };

  public static final String DELIMITER = "========================================================";

  public static void main(String args[]) throws IOException {
	TreeMap<String,TreeMap<String, String>> theWholeInfo = new TreeMap<>();
	SortedSet<String> tickerSymbols = new TreeSet<>();
	for (String eachFile : FILES) {
//	  System.out.println(eachFile);
	  TreeMap<String, String> portfolioShare =  new TreeMap<>();
	  parseRobinMonthlyDoc(eachFile, tickerSymbols, portfolioShare);
	  theWholeInfo.put(eachFile, portfolioShare);
//	  System.out.println(DELIMITER);
	}
	System.out.println("Ticker Symbols "+tickerSymbols);

// replenishing stocks for data entry
	for(Map.Entry<String, TreeMap<String, String>> eachME : theWholeInfo.entrySet()) {
	  replenishSymbols(eachME.getValue(), tickerSymbols);
//	  System.out.println(eachME.getValue());
	}

	System.out.println(DELIMITER);
	for(Map.Entry<String, TreeMap<String, String>> eachME : theWholeInfo.entrySet()) {
	  System.out.println("File Name "+eachME.getKey());
	  for(Map.Entry<String, String> eachME1 : eachME.getValue().entrySet()){
		if(!eachME1.getKey().equals("PortFolioValue")){
		  System.out.println(eachME1.getKey() + " " +eachME1.getValue());
		}

	  }
	  System.out.println("Portfolio Value "+eachME.getValue().get("PortFolioValue"));
	  System.out.println(DELIMITER);
	}

	return;
  }

  private static void replenishSymbols(TreeMap<String,String> monthValue, SortedSet<String> tickerSymbols) {
    for (String sym : tickerSymbols) {
      if(monthValue.get(sym) == null){
        monthValue.put(sym, "0.00%");
	  }
	}
  }

  private static void parseRobinMonthlyDoc(String fileName, SortedSet<String> tickerSymbols, TreeMap<String, String> portfolioShare )
	  throws IOException {
	//Loading an existing document
	File file = new File(fileName);
	PDDocument document = PDDocument.load(file);
	//Instantiate PDFTextStripper class
	PDFTextStripper pdfStripper = new PDFTextStripper();
	//Retrieving text from PDF document
	String text = pdfStripper.getText(document);
	String[] splitText = text.split("\n");
	for (String eachLine : splitText) {
	  if (patternChecker(eachLine) == 1) {
//		System.out.println(eachLine);
		extractTicker(tickerSymbols, eachLine, portfolioShare);
	  } else if (patternChecker(eachLine) == 2) {
//		System.out.println(DELIMITER);
		String[] words = eachLine.split(" ");
//		System.out.println(eachLine);
		portfolioShare.put("PortFolioValue", words[3]);
//		System.out.println(DELIMITER);
	  }

	}
	//Closing the document
	document.close();
  }

  private static void extractTicker(SortedSet<String> tickerSymbols, String eachLine, TreeMap<String, String> portfolioShare) {
	// Fetching symbol from the portfolio
	String[] words = eachLine.split(" ");
	if(eachLine.contains("Estimated"))
	{
	  tickerSymbols.add(words[3]);
	  portfolioShare.put(words[3], words[9] +" : "+words[5]);
	}
	else
	{
	  tickerSymbols.add(words[0]);
	  portfolioShare.put(words[0], words[6] +" : "+words[2]);
	}
  }

  private static int patternChecker(String str) {

	int returnPattern = 0;

	String patternToSearch1 = " Margin ";
	String patternToSearch2 = "Estimated Yield";
	String patternToSearch3 = "Total Priced Portfolio";

	String excludePattern1 = " Buy ";
	String excludePattern2 = " Fee ";
	String excludePattern3 = " Sell ";
	String excludePattern4 = "ACH ";
	String excludePattern5 = " CDIV ";
	String excludePattern6 = "Crypto Money";
	String excludePattern7 = "Unsolicited";



	// Include pattern
	Pattern pattern1 = Pattern.compile(patternToSearch1);
	Pattern pattern2 = Pattern.compile(patternToSearch2);
	Pattern pattern3 = Pattern.compile(patternToSearch3);

	//Exclude Pattern
	Pattern excPattern1 = Pattern.compile(excludePattern1);
	Pattern excPattern2 = Pattern.compile(excludePattern2);
	Pattern excPattern3 = Pattern.compile(excludePattern3);
	Pattern excPattern4 = Pattern.compile(excludePattern4);
	Pattern excPattern5 = Pattern.compile(excludePattern5);
	Pattern excPattern6 = Pattern.compile(excludePattern6);
	Pattern excPattern7 = Pattern.compile(excludePattern7);

	// include
	Matcher matcher1 = pattern1.matcher(str);
	Matcher matcher2 = pattern2.matcher(str);
	Matcher matcher3 = pattern3.matcher(str);

	// Exclude

	Matcher excludematcher1 = excPattern1.matcher(str);
	Matcher excludematcher2 = excPattern2.matcher(str);
	Matcher excludematcher3 = excPattern3.matcher(str);
	Matcher excludematcher4 = excPattern4.matcher(str);
	Matcher excludematcher5 = excPattern5.matcher(str);
	Matcher excludematcher6 = excPattern6.matcher(str);
	Matcher excludematcher7 = excPattern7.matcher(str);

	if (matcher1.find() && !(excludematcher1.find() || excludematcher2.find() || excludematcher3
		.find() || excludematcher4.find() || excludematcher5.find() || excludematcher6.find() || excludematcher7.find())) {
	  returnPattern = 1;
	} else if (matcher3.find()) {
	  returnPattern = 2;
	}

	return returnPattern;
  }


}
