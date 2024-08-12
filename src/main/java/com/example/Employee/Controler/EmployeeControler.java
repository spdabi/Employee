package com.example.Employee.Controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Exception.EmptyException;
import com.example.Employee.Exception.NameNotFoundException;
import com.example.Employee.Service.EmployeeService;

@RestController
@RequestMapping(value="/Employee")
public class EmployeeControler {
	@Autowired
	EmployeeService es;
	
	@PostMapping(value="/PostEmp")
	public String PostThis(@RequestBody Employee e) {
		return es.PostThis(e);
	}
	@GetMapping(value="/allEmp")
	public List<Employee> getthis() {
		return es.getthis();
	}
	@GetMapping(value="/allId/{a}")
	public Employee getthis2(@PathVariable int a) {
		return es.getthis2(a);
	}

	@PutMapping(value="/empUpdate")
	public String putThis(@RequestBody Employee e) {
		return es.putThis(e);
	}
	@DeleteMapping(value="/delete/{a}")
	public String deletethis(@PathVariable int a) {
		return es.deletethis(a);
	}
	
	@GetMapping(value="/getAges")
	public List<Employee> getAge(){
		return es.getAge();
	}
	@GetMapping(value="/getSecMax")
	public List<Employee> geSecmax(){
		return es.getSalary();
	}
	@GetMapping(value="/getAges/{age}")
	public List<Employee> getAges(@PathVariable int age){
		return es.getAges(age);
	}
	@GetMapping(value="/getSalaryss")
	public Employee getSalarycon(){
		return es.getSalarys();
	}
	@GetMapping(value="/getageSalary/{age}/{salary}")
	public List<Object> getAgeSalCon(@PathVariable int age,@PathVariable int salary){
		return es.getAgeSalaryser(age, salary);
		
	}
	@GetMapping(value="/getmidAgeSa/{age}/{ag}/{salary}")
	public Employee getMidAgeCon(@PathVariable int age,@PathVariable int ag,@PathVariable int salary) {
		return es.getmidServ(age,ag,salary);
	}
	
	@GetMapping(value="/getageSalary/{age}")
	public List<Employee> getAgecon(@PathVariable int age){
		return es.getAgeSaSer(age);
	}
	
	//Exception
	@GetMapping(value="/getName/{id}")
	public String getName(@PathVariable int id)throws NameNotFoundException{
		try {
			return es.getName(id);
		}
		catch(NameNotFoundException ne) {
			return "No Name Founnd";
		}
	}
	@GetMapping(value="/getNameEmpty/{name}")
	public Optional<Employee> getEMptyName(@PathVariable String name) throws EmptyException{
	
		return es.getGlobNa(name);
	}
	@PutMapping(value="/PutAgeGlobe")
	public String getGlobAgehj(@RequestBody Employee age) throws EmptyException {
		return es.getGloabAge(age);
	}
	
	@PatchMapping(value="/patch/{id}")
	public String Patch(@RequestBody Employee e,@PathVariable int id) {
		return es.Patch(e, id);
	}
}
