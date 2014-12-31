package com.stefanbanu.app;

import java.io.File;


public class PersonFileFilter extends javax.swing.filechooser.FileFilter {

	@Override
	public boolean accept(File f) {
		String name = f.getName();
		
		String extension = Utils.getFileExtension(name);
		
		if(f.isDirectory()){
			return true;
		}
		
		if(extension == null){
			return false;
		}
		if(extension.equals("per")){
			return true;
		}
		
		return false;
	}

	@Override
	public String getDescription() {
		return "Person database files (*.per)";
	}

}
