package com.example.Employee.Repasitary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Employee.Entity.Employee;

import jakarta.persistence.NamedQuery;

public interface EmployeeRepocitary extends JpaRepository<Employee,Integer> {
	//native query
	@Query(value ="select * from employee_db where age > ?", nativeQuery=true)
	public List<Employee> getAges(int age);
	
	@Query(value ="select * from employee_db where salary =(select max(salary)FROM employee_db)", nativeQuery=true)
	public Employee getSalarys();
	
	@Query(value ="select name,age from employee_db where age < ? and salary > ?",nativeQuery=true)
	public List<Object> getAgeSalary(int age,int salary);
	
	@Query(value ="select * from employee_db where age> ? and age< ? and salary < ? ",nativeQuery=true)
	public Employee getmidAge(int age,int ag, int salary);
	
	//jpa query
	
	@Query(value="select a from Employee a where a.age>=:age")
	public List<Employee> getAgesre(@Param("age") int age);
	
	//exception
	@Query(value="select * from employee_db  where name= ?",nativeQuery=true)
	public List<Employee> getEmptynma(String name);
	
	//GlobException
	@Query(value="select * from employee_db  where name like ?",nativeQuery=true)
	public Optional<Employee> GetGlob(String name);
	
}
