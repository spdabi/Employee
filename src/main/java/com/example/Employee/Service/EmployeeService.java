package com.example.Employee.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Employee.Dao.EmployeeDao;
import com.example.Employee.Entity.Employee;
import com.example.Employee.Exception.EmptyException;
import com.example.Employee.Exception.NameNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;

	public String PostThis(Employee e) {
		return ed.PostThis(e);
	}

	public List<Employee> getthis() {
		return ed.getthis();
	}

	public Employee getthis2( int a) {
		return ed.getthis2(a);
	}

	public String putThis(Employee e) {
		return ed.putThis(e);
	}

	public String deletethis(int a) {
		return ed.deletethis(a);
	}

	public List<Employee> getAge() {
		List<Employee> emp=ed.getthis();
		List<Employee> ages=emp.stream().filter(x->x.getAge()>30).collect(Collectors.toList());
		return ages;
	}
	public List<Employee> getSalary() {
		List<Employee> emp=ed.getthis();
		List<Employee> mAge=emp.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).limit(2).skip(1).collect(Collectors.toList());
		return mAge;
	}
	public List<Employee> getAges(int Age){
		return ed.getAges(Age);
	}
	public Employee getSalarys() {
		return ed.getSalarys();
	}
	public List<Object> getAgeSalaryser(int age,int salary) {
		return ed.getAgesaldeo(age,salary);
	}
	public Employee getmidServ(int age,int ag, int salary) {
		return ed.getmidSall(age,ag,salary);
	}
	
	public List<Employee> getAgeSaSer(int age){
		return ed.getAgedeo(age);
	}
	
	public String getName(int id) throws NameNotFoundException{
		if(ed.getName(id).startsWith("s")) {
			return ed.getName(id);
		}
		else {
			throw new NameNotFoundException("No asaName Found");
		}
	}
//	public Employee getNameExc(String name) throws EmptyException{
//		if(ed.getEmpdao(name).isEmpty()) {
//			throw new EmptyException("Not Fount");
//		}
//		else {
//		return ed.getEmpdao(name).get();
//		}
//	}
	public Optional<Employee> getGlobNa(String name) throws EmptyException{
		if(ed.getGlob(name).isEmpty()) {
			throw new EmptyException("Not Found");
		}
		else {
			return ed.getGlob(name);
		}
	}
	public String getGloabAge(Employee age) throws EmptyException{
		if(age.getAge()>18) {
			return ed.GetGlobageDao(age);
		}
		else {
			throw new EmptyException("Invalidate");
		}
	}
	public String Patch(Employee e,int id) {
		return ed.Patch(e, id);
	}
}