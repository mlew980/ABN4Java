package com.codescribe.abn4java.examples;

import com.codescribe.abn4java.client.ABN4Java;
import com.codescribe.abn4java.client.ABN4JavaExecutionException;
import com.codescribe.abn4java.model.ABN;

public class ABNSearchExample {
	public static void main(String[] args) {
		ABN4Java abnClient = new ABN4Java("<guid>");
		try {
			//ABN Lookup - ABN search - Refer to object properties
			ABN abn = abnClient.ABNLookupABNSearch("74172177893");
			System.out.println("ABN:"+abn.getAbn()); 
			//--------------------------------------------
			//Output
			//--------------------------------------------
			//ABN:74172177893
			//--------------------------------------------
		} catch (ABN4JavaExecutionException e) {
		  e.printStackTrace();
		}
	}
}
