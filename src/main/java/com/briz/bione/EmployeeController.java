package com.briz.bione;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//  THIS IS BIDIRECTIONAL ONE TO ONE MAPPING BOTH ENTITY ALL FIELDS
//  BOTH OF THE REPOSITORY CAN BE USED DEPENDING UPON THE REQUIREMENT 
// ALL THE FIELDS WILL BE DISPLAYED USE DTO FOR PROJECTION 
@RestController
public class EmployeeController 
{
@Autowired
EmployeeRepository erepo;
@Autowired
AddressRepository arepo;
@RequestMapping("/")
public String hello()
{
	return "this is employee test";
}
@RequestMapping("/saving")
public String save()
{
	Employee e=new Employee();
	Address a=new Address();
	a.setAstreet("ratu chowk"); a.setAcity("patna");
	e.setEname("abhinav kumar");e.setEdept("milkwwala");
	e.setAddress(a);// employee to address 
	a.setEmployee(e); // address to employee
	// note this is bi-directional mapping 
	erepo.save(e); // save the repo
	return "data saved into table";
}
@RequestMapping("/all")
public List<Employee> all()
{
	return erepo.findAll();
}
@RequestMapping("/{id}")
public List<Employee> byid(@PathVariable int id)
{
	return erepo.findById(id);
}
@RequestMapping("/del/{id}")
public String delete(@PathVariable int id)
{
	erepo.deleteById(id);
    return "emp deleted";
}
@RequestMapping("/alldata")
public List<Address> byaddress() //  ADDRESS REPO IS USED I.E BIDIRECTIONAL 
{
	return arepo.findAll();
}
// as this is bidirectional any repo can be used 

@RequestMapping("/city/{acity}")
public List<Address> bycity(@PathVariable String acity)
{
	return arepo.findByacity(acity);
}
//  ANY PART OF THE ENTITY Can BE USED INTO BIDIRECTIONAL MAPPING WITH REPO SET 
}
