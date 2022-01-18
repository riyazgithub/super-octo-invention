package com.year2019;

import com.year2021.helper.Codec;

public class Solution_Nov18 {

  public static void main(String[] args) throws Exception{

    String url = "https://leetcode.com/problems/design-tinyurl";
    Codec codec = new Codec();
    String encodedUrl = codec.encode(url);
    codec.decode(encodedUrl);
    System.out.println("Domain Name "+ codec.getDomainName(url));
  }
}



// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));