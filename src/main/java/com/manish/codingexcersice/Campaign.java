package com.manish.codingexcersice;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Campaign")
public class Campaign {
String partner_id;
int Campaign_id;
int duration;
String ad_content;
Calendar creation_time;
Boolean active;

public String getPartner_id() {
	return partner_id;
}
public void setPartner_id(String partner_id) {
	this.partner_id = partner_id;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public String getAd_content() {
	return ad_content;
}
public void setAd_content(String ad_content) {
	this.ad_content = ad_content;
}
public Calendar getCreation_time() {
	return creation_time;
}
public void setCreation_time(Calendar creation_time) {
	this.creation_time = creation_time;
	this.creation_time.add(Calendar.SECOND, duration);
}
public int getCampaign_id() {
	return Campaign_id;
}
public void setCampaign_id(int campaign_id) {
	Campaign_id = campaign_id;
}

public Boolean isActive(){
	
	if(creation_time.compareTo(Calendar.getInstance())==1){
		this.active=true;
	}else{
		this.active=false;
	}
	return this.active;
}


}
