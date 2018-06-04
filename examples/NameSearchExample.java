package com.codescribe.abn4java.examples;

import java.util.List;

import com.codescribe.abn4java.client.ABN4Java;
import com.codescribe.abn4java.client.ABN4JavaExecutionException;
import com.codescribe.abn4java.model.Company;

public class NameSearchExample {
	public static void main(String[] args) {
		ABN4Java abnClient = new ABN4Java("<guid>");
		try {
		  //ABN Lookup - Name Search - Refer to object properties
		  List<Company> companies = abnClient.ABNLookupNameSearch("department of Industry");
		  for(Company company : companies) {
			  System.out.println("Name:" + company.getName());
		  }
		  //--------------------------------------------
		  //Output
		  //--------------------------------------------
		  //Name:DEPARTMENT OF INDUSTRY
		  //Name:DEPARTMENT OF INDUSTRY
		  //Name:DEPARTMENT OF INDUSTRIAL RELATIONS
		  //Name:DEPARTMENT OF INDUSTRIAL RELATIONS
		  //Name:DEPARTMENT OF INDUSTRIES AND BUSINESS
		  //Name:DEPARTMENT OF INDUSTRY AND RESOURCES
		  //Name:DEPARTMENT OF INDUSTRY AND SCIENCE
		  //Name:DEPARTMENT OF INDUSTRY AND TECHNOLOGY
		  //Name:DEPARTMENT OF INDUSTRY AND TRADE
		  //Name:DEPARTMENT OF PRIMARY INDUSTRIES
		  //--------------------------------------------
		} catch (ABN4JavaExecutionException e) {
		  e.printStackTrace();
		}
	}
}
