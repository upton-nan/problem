package com.app.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: AppendComma
 * @Description: 拼接逗号方法
 * @author lyn
 * @date 2020年3月8日
 *
 */
public class AppendComma {

	public static void main(String[] args) {
		AppendComma appendComma = new AppendComma();
		List<String> strList = new ArrayList<>();
		strList.add("1");
		strList.add("2");
		strList.add("55");
		strList.add("66");
		strList.add("77");
		strList.add("3434");
		String resultStr1 = appendComma.method1(strList);
		System.out.println(resultStr1);
		String resultStr2 = appendComma.method2(strList);
		System.out.println(resultStr2);

	}

	public String method1(List<String> strList) {
		String appendStr = "";
		for (String str : strList) {
			if (appendStr.length() > 0) {
				appendStr += ",";
			}
			appendStr += str;
		}
		return appendStr;
	}

	public String method2(List<String> strList) {
		String appendStr = "";
		for (String str : strList) {
			appendStr += str + ",";
		}
		appendStr = appendStr.substring(0, appendStr.length() - 1);
		return appendStr;
	}
}
