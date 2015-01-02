package com.stefanbanu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.stefanbanu.gui.FormEvent;
import com.stefanbanu.model.AgeCategory;
import com.stefanbanu.model.Database;
import com.stefanbanu.model.EmploymentCategory;
import com.stefanbanu.model.Gender;
import com.stefanbanu.model.Person;

public class Controller {
	Database db = new Database();
	
	public List<Person> getPeople(){
		return db.getListPeople();
	}

	public void addPerson(FormEvent ev){
		String name = ev.getName();
		String occupation = ev.getOccupation();
		int ageCatId = ev.getAge();
		String empCat = ev.getEmploymentCategory();
		boolean isUs = ev.isUsCitizen();
		String taxId = ev.getTaxId();
		String gender = ev.getGender();
		
		AgeCategory ageCategory = null;
		
		switch (ageCatId) {
		case 0:
			ageCategory = AgeCategory.child;
			break;
		case 1:
			ageCategory = AgeCategory.adult;
			break;
		case 2:
			ageCategory = AgeCategory.senior;
			break;
		}
		
		EmploymentCategory empCategory;
		
		if(empCat.equals("employed")){
			empCategory = EmploymentCategory.employed;
		}else if(empCat.equals("self-employed")){
			empCategory = EmploymentCategory.selfEmployed;
		}else if(empCat.equals("unemployed")){
			empCategory = EmploymentCategory.unemployed;
		}else 
			{
			empCategory = EmploymentCategory.other;
			System.err.println(empCat);
		}
		
		Gender genderCat;
		
		if(gender.equals("male")){
			genderCat = Gender.male;
		}else {
			genderCat = Gender.female;
		}
		
		
		Person newPerson = new Person(name, occupation, ageCategory, empCategory, taxId, isUs, genderCat  );
		db.addPerson(newPerson);
	}
	
	public void saveToFile(File file) throws IOException{
		db.saveToFile(file);
	}
	public void loadFromFile(File file) throws IOException{
		db.loadFromFile(file);
	}

	public void removePerson(int row) {
		db.removePerson(row);
		
	}
}
