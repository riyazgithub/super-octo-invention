package com;

class shareDetails {
  Double value;
  Double count;

  @Override
  public String toString() {
	return "shareDetails{" +
		"value=" + value +
		", count=" + count +
		'}';
  }

  public shareDetails(Double val, Double c) {
	value = val;
	count =c;
  }

    public static void main(String[] args) {
      String s1 = "Retrieved table from cdp with tableId : %s for ";
      String s2 = "MktDataLake with  Id : %s and with name : %s linked to core dataStream Id : %s";
        System.out.println(s1);
//        System.out.println(        String.format(s1,
//                "12", "coreMktDataLake.getId()"));
        System.out.println(String.format(s1+s2,
                "12", "coreMktDataLake.getId()", "coreMktDataLake.getName()", "coreDataStreamId"));
    }
}
