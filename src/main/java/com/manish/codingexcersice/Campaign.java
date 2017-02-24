package com.manish.codingexcersice;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Campaign")
public class Campaign {

Calendar Creation_and_duration_time;
String partner_id;
int Campaign_id;
int duration;
String ad_content;
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
public Calendar getCreation_and_duration_time() {
	return Creation_and_duration_time;
}
public void setCreation_and_duration_time(Calendar creation_time) {
	this.Creation_and_duration_time = creation_time;
	this.Creation_and_duration_time.add(Calendar.SECOND, duration);
}
public int getCampaign_id() {
	return Campaign_id;
}
public void setCampaign_id(int campaign_id) {
	Campaign_id = campaign_id;
}

public Boolean isActive(){
	
	if(Creation_and_duration_time.compareTo(Calendar.getInstance())==1){
		System.out.println("==3Creation+duration==3"+Creation_and_duration_time);
		this.active=true;
	}else{
		System.out.println("==expired time==3");
		this.active=false;
	}
	return this.active;
}


}
