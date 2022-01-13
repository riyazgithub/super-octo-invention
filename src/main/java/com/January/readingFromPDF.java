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
	  "/Users/rafthab/Downloads/Finance/Robinhood/Dec2019.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Jan2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Feb2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Mar2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/APR2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/MAY2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Jun2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Jul2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Aug2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/SEP2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Oct2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Nov2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Dec2020.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Jan2021.pdf",
	  "/Users/rafthab/Downloads/Finance/Robinhood/Feb2021.pdf",
		  "/Users/rafthab/Downloads/Finance/Robinhood/MAR2021.pdf",
		  "/Users/rafthab/Downloads/Finance/Robinhood/APR2021.pdf",
		  "/Users/rafthab/Downloads/Finance/Robinhood/MAY2021.pdf",
		  "/Users/rafthab/Downloads/Finance/Robinhood/Jun2021.pdf",
		  "/Users/rafthab/Downloads/Finance/Robinhood/Jul2021.pdf",
		  "/Users/rafthab/Downloads/Finance/Robinhood/Aug2021.pdf",
		  "/Users/rafthab/Downloads/Finance/Robinhood/Sep2021.pdf",
		  "/Users/rafthab/Downloads/Finance/Robinhood/Oct2021.pdf",
		  "/Users/rafthab/Downloads/Finance/Robinhood/Nov2021.pdf"
  };

  public static final String DELIMITER = "========================================================";

  // TODO: Need to remove the below stocks
  /*
  *
  * AAPL
EXPE
IPOC
LUV
RDS.B
SSTI
TRIP
WORK
  * */

  public static void main(String args[]) throws IOException {
	TreeMap<String,TreeMap<String, String>> theWholeInfoPercent = new TreeMap<>();
	TreeMap<String,TreeMap<String, String>> theWholeInfoShares = new TreeMap<>();
	SortedSet<String> tickerSymbols = new TreeSet<>();
	for (String eachFile : FILES) {
//	  System.out.println(eachFile);
	  TreeMap<String, String> portfolioSharePercent =  new TreeMap<>();
	  TreeMap<String, String> shareCount =  new TreeMap<>();
	  parseRobinMonthlyDoc(eachFile, tickerSymbols, portfolioSharePercent, shareCount);
	  theWholeInfoPercent.put(eachFile, portfolioSharePercent);
	  theWholeInfoShares.put(eachFile,shareCount);
//	  System.out.println(DELIMITER);
	}
	System.out.println("Ticker Symbols "+tickerSymbols);

// replenishing stocks for data entry
	for(Map.Entry<String, TreeMap<String, String>> eachME : theWholeInfoPercent.entrySet()) {
	  replenishSymbols(eachME.getValue(), tickerSymbols);
//	  System.out.println(eachME.getValue());
	}
	// For Shares
	for(Map.Entry<String, TreeMap<String, String>> eachME : theWholeInfoShares.entrySet()) {
	  replenishSymbols(eachME.getValue(), tickerSymbols);
	}

	String month = "Nov2021";

	System.out.println(DELIMITER);
	printingData(theWholeInfoPercent, month);
	System.out.println(DELIMITER);
	printingData(theWholeInfoShares, month);

	  System.out.println(DELIMITER);
	  printingDataWithoutTicker(theWholeInfoPercent, month);
	  System.out.println(DELIMITER);
	  printingDataWithoutTicker(theWholeInfoShares, month);

	return;
  }

  private static void printingData(TreeMap<String, TreeMap<String, String>> theWholeInfoPercent, String fileName) {
	for(Map.Entry<String, TreeMap<String, String>> eachME : theWholeInfoPercent.entrySet()) {
	  System.out.println("File Name "+eachME.getKey());
	  if(eachME.getKey().contains(fileName))
	  {
		  for(Map.Entry<String, String> eachME1 : eachME.getValue().entrySet()){
//		if(!eachME1.getKey().equals("PortFolioValue") && !eachME1.getValue().equals("0.00%")){
			  if(!eachME1.getKey().equals("PortFolioValue")){
				  // Stock ticker : Number of shares
		  System.out.println(eachME1.getKey() + " " +eachME1.getValue());
			  }
		  }
	  }
	  System.out.println("Portfolio Value "+eachME.getValue().get("PortFolioValue"));
	  System.out.println(DELIMITER);
	}
  }

	private static void printingDataWithoutTicker(TreeMap<String, TreeMap<String, String>> theWholeInfoPercent, String fileName) {
		for(Map.Entry<String, TreeMap<String, String>> eachME : theWholeInfoPercent.entrySet()) {
			System.out.println("File Name "+eachME.getKey());
			if(eachME.getKey().contains(fileName))
			{
				for(Map.Entry<String, String> eachME1 : eachME.getValue().entrySet()){
//		if(!eachME1.getKey().equals("PortFolioValue") && !eachME1.getValue().equals("0.00%")){
					if(!eachME1.getKey().equals("PortFolioValue")){
						// Stock ticker : Number of shares
//		  System.out.println(eachME1.getKey() + " " +eachME1.getValue());
						// number of shares (with out ticker)
						System.out.println(eachME1.getValue());
					}
				}
			}
			System.out.println("Portfolio Value "+eachME.getValue().get("PortFolioValue"));
			System.out.println(DELIMITER);
		}
	}
	
  private static void replenishSymbols(TreeMap<String,String> monthValue, SortedSet<String> tickerSymbols) {
    for (String sym : tickerSymbols) {
      if(monthValue.get(sym) == null){
        monthValue.put(sym, "0.00%");
	  }
	}
  }

  private static void parseRobinMonthlyDoc(String fileName, SortedSet<String> tickerSymbols, TreeMap<String, String> portfolioSharePercentage,TreeMap<String, String> shareCount )
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
		extractTicker(tickerSymbols, eachLine, portfolioSharePercentage, shareCount);
	  } else if (patternChecker(eachLine) == 2) {
//		System.out.println(DELIMITER);
		String[] words = eachLine.split(" ");
//		System.out.println(eachLine);

		portfolioSharePercentage.put("PortFolioValue", words[3]);
//		System.out.println(DELIMITER);
	  } else {
//		  System.out.println("Ecluded >>>>>>>>>>>>>>>>  " +eachLine);
	  }

	}
	//Closing the document
	document.close();
  }

  private static void
  extractTicker(SortedSet<String> tickerSymbols, String eachLine, TreeMap<String, String> portfolioSharePercentage, TreeMap<String, String> shareCount) {
	  try {
		  // Fetching symbol from the portfolio
		  String[] words = eachLine.split(" ");
		  if(eachLine.contains("Estimated") && !words[5].equals("1"))
		  {
			  tickerSymbols.add(words[3]);
//	  portfolioSharePercentage.put(words[3], words[9] +" : "+words[5]);
			  portfolioSharePercentage.put(words[3], words[9]);
			  shareCount.put(words[3], words[5]);
		  }
		  else if (words.length > 6)
		  {
			  tickerSymbols.add(words[0]);
//	  portfolioSharePercentage.put(words[0], words[6] +" : "+words[2]);
			  portfolioSharePercentage.put(words[0], words[6]);
			  shareCount.put(words[0], words[2]);
		  }
	  } catch (Exception exception)
	  {
		  exception.printStackTrace();
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
	  String excludePattern8 = "Call";
	  String excludePattern9 = "BTO";



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
	  Pattern excPattern8 = Pattern.compile(excludePattern8);
	  Pattern excPattern9 = Pattern.compile(excludePattern9);

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
	  Matcher excludematcher8 = excPattern8.matcher(str);
	  Matcher excludematcher9 = excPattern9.matcher(str);

	if (matcher1.find() && !(excludematcher1.find() || excludematcher2.find() || excludematcher3
		.find() || excludematcher4.find() || excludematcher5.find() || excludematcher6.find() || excludematcher7.find()|| excludematcher8.find() || excludematcher9.find())) {
	  returnPattern = 1;
	} else if (matcher3.find()) {
	  returnPattern = 2;
	}

	return returnPattern;
  }


}
