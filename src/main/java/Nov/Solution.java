package Nov;

// Partially correct
public class Solution {


  public int myAtoi(String s) {
    int returnVal;
    String[] splitArr = s.trim().split(" ");
    // Finding number
	String extractNumber = getNumberFromString(splitArr[0]);
	//look for -ve
	boolean isNegative = isNumberNegative(extractNumber);
	// remove trailing zeros
	if(extractNumber.length()>0 && (isNegative || extractNumber.charAt(0) == '+'))
	{
	  extractNumber = extractNumber.substring(1);
	}
	extractNumber = removeZeroes(extractNumber);
	//look for length of the integer
	returnVal = atoiConvert(extractNumber, isNegative);
    return returnVal;
  }

  private String removeZeroes(String extractNumber) {
    char[] parseZeros = extractNumber.toCharArray();
    String newReturn = new String();

    boolean doWeSkip = (extractNumber.length() > 0 && parseZeros[0] == '0') ? true : false;
    for (char c: parseZeros){
      if(doWeSkip) {
        if(c != '0') {
          doWeSkip = false;
		  newReturn += c;
		}
	  } else {
        newReturn += c;
	  }
	}
	return newReturn;
  }

  private int atoiConvert(String extractNumber, boolean isNumberNegative) {
    int returnAtoi = 0;
    int decimalPlace =1;
	int lengthOfInteger = extractNumber.length();
	if(lengthOfInteger > 10)
	{
	  if(isNumberNegative)
	    return Integer.MIN_VALUE;
	  else
	    return Integer.MAX_VALUE;
	}

	char[] charArr = extractNumber.toCharArray();

	for(int i = charArr.length-1; i >=0; i--) {
	  if(i == charArr.length-1){
	    returnAtoi = charArr[i] - 48;
		decimalPlace = decimalPlace*10;
	  } else {
	    returnAtoi += (charArr[i] - 48)*decimalPlace;
		decimalPlace = decimalPlace*10;
	  }
	}
	if(isNumberNegative)
	  returnAtoi = returnAtoi * -1;
	if(isNumberNegative && returnAtoi > 0) {
	  return Integer.MIN_VALUE;
	} else if(!isNumberNegative && returnAtoi < 0) {
	  return Integer.MAX_VALUE;
	}
	return returnAtoi;
  }

  private boolean isNumberNegative(String extractNumber) {
    if(extractNumber.length()>0 && extractNumber.charAt(0) == '-'){
      return true;
	}
	return false;
  }

  private String getNumberFromString(String s) {
    String numberSring = new String();
    char[] charArr = s.toCharArray();
    for(int i=0; i< charArr.length; i++) {
      if((48 <= charArr[i] && charArr[i] <= 57) || charArr[i] == 45 || charArr[i] == 43){
        if(charArr[i] == 45){
          numberSring += "-";
          i++;
		} else if(charArr[i] == 43) i++;
		while (( i < charArr.length) && (48 <= charArr[i] && charArr[i] <= 57)){
          numberSring += charArr[i];
          i++;
		}
	  return numberSring;
      }else {
		return numberSring;
	  }
	}
    return numberSring;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
	System.out.println(solution.myAtoi("-6147483648"));
	int i = -2147483646;
	System.out.println(i-100);
    
  }
}
