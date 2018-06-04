package com.codescribe.abn4java.examples;

import com.codescribe.abn4java.client.ABN4Java;
import com.codescribe.abn4java.client.ABN4JavaExecutionException;
import com.codescribe.abn4java.model.ABN;

public class ACNSearchExample {
	public static void main(String[] args) {
		ABN4Java abnClient = new ABN4Java("<guid>");
		try {
			//ABN Lookup - ACN search - Refer to object properties
			ABN abn = abnClient.ABNLookupACNSearch("008672179");
			System.out.println("ABN:"+abn.getAbn()); 
			//--------------------------------------------
			//Output
			//--------------------------------------------
			//ABN:008672179
			//--------------------------------------------
		} catch (ABN4JavaExecutionException e) {
		  e.printStackTrace();
		}
	}
}
