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
}
