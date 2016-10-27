package org.agent.common;

public class SQLTools {
	public static String transfer(String keyword){
		if(keyword.contains("%")||keyword.contains("_")){
			
			keyword=keyword.replaceAll("\\\\", "\\\\\\\\")
					.replaceAll("\\%", "\\\\%")
		.replaceAll("\\_", "\\\\_");
		}
		return keyword;
	}
}
