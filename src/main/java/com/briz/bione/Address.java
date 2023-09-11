package com.briz.bione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name="address")
public class Address implements Serializable 
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int aId;
String astreet;
String acity;
@OneToOne(cascade=CascadeType.ALL)
@JsonIgnoreProperties("address") // to give the repeating output 
Employee employee;
public int getaId() {
	return aId;
}
public void setaId(int aId) {
	this.aId = aId;
}
public String getAstreet() {
	return astreet;
}
public void setAstreet(String astreet) {
	this.astreet = astreet;
}
public String getAcity() {
	return acity;
}
public void setAcity(String acity) {
	this.acity = acity;
}
public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}
}
