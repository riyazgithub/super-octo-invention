package com.January;

public class FD {

  public static void main(String[] args) {
	double deposit = 1000000l;
	double returnDeposit;
	int mon = 60;
	double rate = 7.5;
	for(int i =0; i<mon-1; i=i+3) {
	  returnDeposit = (deposit * (rate / 100.0)) / 4.0;
	  deposit += returnDeposit;
	}
	System.out.println("Outcome "+deposit);
  }

}
