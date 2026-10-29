package com.acme.salary.service;
import com.acme.salary.dto.*;
import com.acme.salary.entity.Employee;
import com.acme.salary.repository.EmployeeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Locale;
@Service
public class EmployeeService {
 private final EmployeeRepository repo;
 public EmployeeService(EmployeeRepository repo){this.repo=repo;}
 @Transactional(readOnly=true) public Page<EmployeeResponse> list(int page,int size,String search,String country,String department){
  if(page<0)throw new IllegalArgumentException("page must be zero or greater");
  if(size<1||size>100)throw new IllegalArgumentException("size must be between 1 and 100");
  return repo.search(clean(search),clean(country),clean(department),PageRequest.of(page,size,Sort.by("id"))).map(EmployeeResponse::from);
 }
 @Transactional(readOnly=true) public EmployeeResponse get(long id){return EmployeeResponse.from(repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found: "+id)));}
 @Transactional public EmployeeResponse create(EmployeeRequest r){
  if(repo.existsByEmployeeCodeIgnoreCase(r.employeeCode().trim()))throw new DuplicateEmployeeException("Employee code already exists");
  if(repo.existsByEmailIgnoreCase(r.email().trim()))throw new DuplicateEmployeeException("Email already exists");
  Employee e=new Employee(); apply(e,r);
  try{return EmployeeResponse.from(repo.saveAndFlush(e));}catch(DataIntegrityViolationException ex){throw new DuplicateEmployeeException("Employee code or email already exists");}
 }
 @Transactional public EmployeeResponse update(long id,EmployeeRequest r){
  Employee e=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found: "+id));
  repo.findByEmployeeCodeIgnoreCase(r.employeeCode().trim()).ifPresent(other->{if(!other.getId().equals(id))throw new DuplicateEmployeeException("Employee code already exists");});
  if(repo.existsByEmailIgnoreCase(r.email().trim())&&!e.getEmail().equalsIgnoreCase(r.email().trim()))throw new DuplicateEmployeeException("Email already exists");
  apply(e,r);
  try{return EmployeeResponse.from(repo.saveAndFlush(e));}catch(DataIntegrityViolationException ex){throw new DuplicateEmployeeException("Employee code or email already exists");}
 }
 private void apply(Employee e,EmployeeRequest r){e.setEmployeeCode(r.employeeCode().trim());e.setFirstName(r.firstName().trim());e.setLastName(r.lastName().trim());e.setEmail(r.email().trim().toLowerCase(Locale.ROOT));e.setCountry(r.country().trim());e.setDepartment(r.department().trim());e.setJobTitle(r.jobTitle().trim());e.setSalaryAmount(r.salaryAmount());e.setCurrencyCode(r.currencyCode().trim().toUpperCase(Locale.ROOT));}
 private String clean(String s){return s==null?"":s.trim();}
}
