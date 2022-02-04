package com.year2020.helper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Codec {

  public String getDomainName(String url) throws URISyntaxException {
    URI uri = new URI(url);
    String domain = uri.getHost();
    return domain.startsWith("www.") ? domain.substring(4) : domain;
  }

  public String getUrlPath(String url) throws URISyntaxException {
    URI uri = new URI(url);
    String path = uri.getPath();
    return path.substring(1);
  }

  Map<Integer, String> hashmap = new HashMap<>();
  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) throws URISyntaxException {
    String toEncode = getUrlPath(longUrl);
    Integer encode = toEncode.hashCode();
    hashmap.put(encode,longUrl);
    return "https://www.tinyurl.com/"+encode;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) throws URISyntaxException {
    String toDecode = getUrlPath(shortUrl);
    Integer code = Integer.parseInt(toDecode);
    String returnStr = hashmap.get(code);
    return returnStr;
  }
}