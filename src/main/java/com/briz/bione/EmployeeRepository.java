package com.briz.bione;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Integer>
{
List<Employee> findById(int id );
String  deleteById(int id);

}