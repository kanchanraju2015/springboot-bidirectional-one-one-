package com.briz.bione;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name="employee")
public class Employee implements Serializable
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int eId;
String ename;
String edept;
@OneToOne(cascade=CascadeType.ALL)
@JsonIgnoreProperties("employee")// to ignore the repeating output
Address address;
public int geteId() {
	return eId;
}
public void seteId(int eId) {
	this.eId = eId;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEdept() {
	return edept;
}
public void setEdept(String edept) {
	this.edept = edept;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
}
