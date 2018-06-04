package com.codescribe.abn4java.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ABN {
	private String Abn;
	private String AbnStatus;
	private Date AddressDate;
	private String AddressPostcode;
	private String AddressState;
	private List<String> BusinessName;
	private String EntityName;
	private String EntityTypeCode;
	private String EntityTypeName;
	private Date Gst;
	private String Message;
	
	public ABN() {
		BusinessName = new LinkedList<String>();
	}
	
	public String getAbn() {
		return this.Abn;
	}
	
	public void setAbn(final String Abn) {
		this.Abn = Abn;
	}
	
	public String getAbnStatus() {
		return this.AbnStatus;
	}
	
	public void setAbnStatus(final String AbnStatus) {
		this.AbnStatus = AbnStatus;
	}
	
	public Date getAddressDate() {
		return this.AddressDate;
	}
	
	public void setAddressDate(final Date AddressDate) {
		this.AddressDate = AddressDate;
	}
	
	public String getAddressPostcode() {
		return this.AddressPostcode;
	}
	
	public void setAddressPostcode(final String AddressPostcode) {
		this.AddressPostcode = AddressPostcode;
	}
	
	public String getAddressState() {
		return this.AddressState;
	}
	
	public void setAddressState(final String AddressState) {
		this.AddressState = AddressState;
	}
	
	public List<String> getBusinessNames() {
		return this.BusinessName;
	}
	
	public void addBusinessName(final String BusinessName) {
		this.BusinessName.add(BusinessName);
	}
	
	public String getEntityName() {
		return this.EntityName;
	}
	
	public void setEntityName(final String EntityName) {
		this.EntityName = EntityName;
	}
	
	public String getEntityTypeCode() {
		return this.EntityTypeCode;
	}
	
	public void setEntityTypeCode(final String EntityTypeCode) {
		this.EntityTypeCode = EntityTypeCode;
	}
	
	public String getEntityTypeName() {
		return this.EntityTypeName;
	}
	
	public void setEntityTypeName(final String EntityTypeName) {
		this.EntityTypeName = EntityTypeName;
	}
	
	public Date getGst() {
		return this.Gst;
	}
	
	public void setGst(final Date Gst) {
		this.Gst = Gst;
	}
	
	public String getMessage() {
		return this.Message;
	}
	
	public void setMessage(final String Message) {
		this.Message = Message;
	}
}
