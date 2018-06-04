package com.codescribe.abn4java.client;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.codescribe.abn4java.model.ABN;
import com.codescribe.abn4java.model.Company;

public class ABN4Java {
	
	private static final String SCHEMA = "https://";
	private static final String HOST = "abr.business.gov.au";
    private static final String MATCHINGNAMESPATH = "/json/MatchingNames.aspx";
    private static final String ABNDETAILSPATH = "/json/AbnDetails.aspx";
    private static final String ACNDETAILSPATH = "/json/AcnDetails.aspx";
    
    private int maximumResults = 10;
    private String guid = "";
    
    public ABN4Java(final String guid) {
    	this.guid = guid;
    }
    
    public void setMaximumResults(final int maximumResults) {
    	this.maximumResults = maximumResults;
    }
    
    public int getMaximumResults() {
    	return this.maximumResults;
    }
    
    private String generateQueryParameters() {
    	return "?maxResults=" + maximumResults + "&guid=" + guid + "&callback=callback";
    }
    private String getJSON(final URL passedURL) {
    	HttpsURLConnection connection = null;
    	String output = "";
		try {
			final URL url = passedURL;
			connection = (HttpsURLConnection) url.openConnection();
			final SSLContext sc = SSLContext.getInstance("TLSv1.2");
			sc.init(null, null, new java.security.SecureRandom());
			connection.setSSLSocketFactory(sc.getSocketFactory());
			connection.setConnectTimeout(20000); 
            connection.setReadTimeout(20000); 
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			
			DataOutputStream request = new DataOutputStream(connection.getOutputStream());
			request.write(output.getBytes());
			request.flush();
			request.close();
			
			InputStream responseStream = new BufferedInputStream(connection.getInputStream());
			BufferedReader responseStreamReader = new BufferedReader(new InputStreamReader(responseStream));
			String response = new String();
			for (String line; (line = responseStreamReader.readLine()) != null; response += line);
			responseStreamReader.close();
			return response.toString();
    	} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		return "";
    }
    
    public ABN ABNLookupABNSearch(final String lookup) throws ABN4JavaExecutionException {
    	String response;
    	final ABN abn = new ABN();
		try {
			response = getJSON(new URL(SCHEMA + HOST + ABNDETAILSPATH + generateQueryParameters() + "&abn=" + URLEncoder.encode(lookup, "UTF-8")));
			response = response.substring("callback(".length());
			final JSONObject json = new JSONObject(response);
			
			if(json.get("Message").equals("The GUID entered is not recognised as a Registered Party")) {
				System.out.println("Incorrect GUID");
			}
			
			SimpleDateFormat sdDateFormat= new SimpleDateFormat("yyyy-MM-dd");
			
			abn.setAbn(json.getString("Abn"));
			abn.setAbnStatus(json.getString("AbnStatus"));
			abn.setAddressDate(sdDateFormat.parse(json.getString("AddressDate")));
			abn.setAddressPostcode(json.getString("AddressPostcode"));
			abn.setAddressState(json.getString("AddressState"));
			final JSONArray names = json.getJSONArray("BusinessName");
			for (int i = 0; i < names.length(); i++) {
				abn.addBusinessName(names.getString(i));
			}
			abn.setEntityName(json.getString("EntityName"));
			abn.setEntityTypeCode(json.getString("EntityTypeCode"));
			abn.setEntityTypeName(json.getString("EntityTypeName"));
			abn.setGst(sdDateFormat.parse(json.getString("Gst")));
			abn.setMessage(json.getString("Message"));
			return abn;
		} catch (MalformedURLException e) {
			throw new ABN4JavaExecutionException("Issue with the URL generated. Error Message: " + e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new ABN4JavaExecutionException("Issue occured while encoding the lookup variable. Error Message: " + e.getMessage(), e);
		} catch (JSONException e) {
			throw new ABN4JavaExecutionException("Issue with the JSON. Error Message: " + e.getMessage(), e);
		} catch (ParseException e) {
			throw new ABN4JavaExecutionException("Issue occured while parsing the JSON. Error Message: " + e.getMessage(), e);
		}
    }
    
    public ABN ABNLookupACNSearch(final String lookup) throws ABN4JavaExecutionException {
    	String response;
    	final ABN abn = new ABN();
		try {
			response = getJSON(new URL(SCHEMA + HOST + ACNDETAILSPATH + generateQueryParameters() + "&acn=" + URLEncoder.encode(lookup, "UTF-8")));
			response = response.substring("callback(".length());
			final JSONObject json = new JSONObject(response);
			
			if(json.get("Message").equals("The GUID entered is not recognised as a Registered Party")) {
				System.out.println("Incorrect GUID");
			}
			
			SimpleDateFormat sdDateFormat= new SimpleDateFormat("yyyy-MM-dd");
			
			abn.setAbn(json.getString("Abn"));
			abn.setAbnStatus(json.getString("AbnStatus"));
			abn.setAddressDate(sdDateFormat.parse(json.getString("AddressDate")));
			abn.setAddressPostcode(json.getString("AddressPostcode"));
			abn.setAddressState(json.getString("AddressState"));
			final JSONArray names = json.getJSONArray("BusinessName");
			for (int i = 0; i < names.length(); i++) {
				abn.addBusinessName(names.getString(i));
			}
			abn.setEntityName(json.getString("EntityName"));
			abn.setEntityTypeCode(json.getString("EntityTypeCode"));
			abn.setEntityTypeName(json.getString("EntityTypeName"));
			abn.setGst(sdDateFormat.parse(json.getString("Gst")));
			abn.setMessage(json.getString("Message"));
			return abn;
		} catch (MalformedURLException e) {
			throw new ABN4JavaExecutionException("Issue with the URL generated. Error Message: " + e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new ABN4JavaExecutionException("Issue occured while encoding the lookup variable. Error Message: " + e.getMessage(), e);
		} catch (JSONException e) {
			throw new ABN4JavaExecutionException("Issue with the JSON. Error Message: " + e.getMessage(), e);
		} catch (ParseException e) {
			throw new ABN4JavaExecutionException("Issue occured while parsing the JSON. Error Message: " + e.getMessage(), e);
		}
    }
    
    public List<Company> ABNLookupNameSearch(final String lookup) throws ABN4JavaExecutionException {
    	List<Company> lCompanies = new ArrayList<Company>();
    	
    	String response;
		try {
			response = getJSON(new URL(SCHEMA + HOST + MATCHINGNAMESPATH + generateQueryParameters() + "&name=" + URLEncoder.encode(lookup, "UTF-8")));
			response = response.substring("callback(".length());
			final JSONObject json = new JSONObject(response);
			
			if(json.get("Message").equals("The GUID entered is not recognised as a Registered Party")) {
				System.out.println("Incorrect GUID");
			}
			final JSONArray names = json.getJSONArray("Names");
			for (int i = 0; i < names.length(); i++) {
				JSONObject obj = names.getJSONObject(i);
				Company company = new Company();
				company.setAbn(obj.getString("Abn"));
				company.setAbnStatus(obj.getString("AbnStatus"));
				company.setIsCurrent(obj.getBoolean("IsCurrent"));
				company.setName(obj.getString("Name"));
				company.setNameType(obj.getString("NameType"));
				company.setPostcode(obj.getString("Postcode"));
				company.setScore(obj.getInt("Score"));
				company.setState(obj.getString("State"));
				lCompanies.add(company);
			}
		} catch (MalformedURLException e) {
			throw new ABN4JavaExecutionException("Issue with the URL generated. Error Message: " + e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new ABN4JavaExecutionException("Issue occured while encoding the lookup variable. Error Message: " + e.getMessage(), e);
		} catch (JSONException e) {
			throw new ABN4JavaExecutionException("Issue with the JSON. Error Message: " + e.getMessage(), e);
		} 
		return lCompanies;
    }
}