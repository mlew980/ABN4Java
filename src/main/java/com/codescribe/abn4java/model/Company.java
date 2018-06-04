package com.codescribe.abn4java.model;

public class Company {
	private String Abn;
	private String AbnStatus;
	private boolean IsCurrent;
	private String Name;
	private String NameType;
	private String Postcode;
	private int Score;
	private String State;
	
	public Company(){}
	
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
	
	public boolean getIsCurrent() {
		return this.IsCurrent;
	}
	
	public void setIsCurrent(final boolean IsCurrent) {
		this.IsCurrent = IsCurrent;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setName(final String Name) {
		this.Name = Name;
	}
	
	public String getNameType() {
		return this.NameType;
	}
	
	public void setNameType(final String NameType) {
		this.NameType = NameType;
	}
	
	public String getPostcode() {
		return this.Postcode;
	}
	
	public void setPostcode(final String Postcode) {
		this.Postcode = Postcode;
	}
	
	public int getScore() {
		return this.Score;
	}
	
	public void setScore(final int Score) {
		this.Score = Score;
	}
	
	public String getState() {
		return this.State;
	}
	
	public void setState(final String State) {
		this.State = State;
	}
}
