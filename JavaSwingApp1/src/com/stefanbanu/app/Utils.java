package com.stefanbanu.app;

public class Utils {
	
	public static String getFileExtension(String name){
		
		int pointIndex = name.lastIndexOf(".");
		// if it is -1 it means no dot "." was find in the file
		if(pointIndex == -1){
			return null;
		}
		// it means that the dot "." is right at the end so it is not an extension
		if(pointIndex == name.length() - 1){
			return null;
		}
		
		return name.substring(pointIndex+1, name.length());
	}

}
