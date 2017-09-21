package com.icefox.example;

public class Test20170523 {

	public static void main(String[] args) {
		String requestDomain = "www.baidu.cn";
		String domainName = "m.zbj.com";
		requestDomain = getDomain(requestDomain);
		System.out.println(getDomain(requestDomain, domainName));
	}

	public static String getDomain(String requestURL) {
		int startIndex = requestURL.indexOf(".");
		int endIndex = requestURL.indexOf(".", startIndex + 1);
		return requestURL.substring(startIndex + 1, endIndex);
	}

	public static String getDomain(String requestDomain, String target) {
		int startIndex = target.indexOf(".");
		int endIndex = target.indexOf(".", startIndex + 1);
		return new StringBuffer().append(target.substring(0, startIndex + 1)).append(requestDomain)
				.append(target.substring(endIndex)).toString();
	}
}
