package com.example.Employee.Dao;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repasitary.EmployeeRepocitary;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepocitary er;

	public String PostThis(Employee e) {
	
		er.save(e);
		return "Post Successfully Saved";
	}

	public List<Employee> getthis() {

		return er.findAll();
	}

	public Employee getthis2(int a) {
		return er.findById(a).get();
	}

	public String putThis(Employee e) {
		er.save(e);
		return "Put Successfully";
	}

	public String deletethis(int a) {
		er.deleteById(a);
		return "delete sucsussfully";
	}
	public List<Employee> getAges(int age){
		return er.getAges(age);
	}
	public Employee getSalarys(){
		return er.getSalarys();
	}
	public List<Object> getAgesaldeo(int age,int salary){
		return er.getAgeSalary(age, salary);
	}
	public Employee getmidSall(int age,int ag, int salary) {
		return er.getmidAge(age,ag,salary);
	}
	
	
	public List<Employee> getAgedeo(int age){
		return er.getAgesre(age);
	}
	
	public String getName(int id) {
		return er.findById(id).get().getName();
	}
	
//	public Optional<Employee> getEmpdao(String name) {
//		return er.getEmptynma(name);
//	}
	
	
	public Optional<Employee> getGlob(String name) {
		return er.GetGlob(name);
	}
	
	public String GetGlobageDao(Employee age) {
		er.save(age);
		return "Put Successfully";
	}
	public String Patch(Employee e,int id) {
		Employee x=er.findById(id).get();
		x.setAge(e.getAge());
		er.save(x);
		return "Updated Succesfully";
	}

}
