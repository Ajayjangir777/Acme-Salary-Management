package com.acme.salary.service;
import com.acme.salary.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class AnalyticsService {
 private final EmployeeRepository repo;
 public AnalyticsService(EmployeeRepository repo){this.repo=repo;}
 public Map<String,Object> summary(){
  Map<String,Object> result=new LinkedHashMap<>();
  result.put("employeeCount",repo.count());
  result.put("byCurrency",map(repo.summaryByCurrency(),false));
  result.put("byCountryAndCurrency",map(repo.summaryByCountryCurrency(),true));
  result.put("byDepartmentAndCurrency",map(repo.summaryByDepartmentCurrency(),true));
  return result;
 }
 private List<Map<String,Object>> map(List<Object[]> rows,boolean grouped){
  List<Map<String,Object>> result=new ArrayList<>();
  for(Object[] row:rows){int i=0;Map<String,Object> m=new LinkedHashMap<>();
   if(grouped)m.put("group",row[i++]);m.put("currencyCode",row[i++]);m.put("employeeCount",((Number)row[i++]).longValue());m.put("totalSalary",row[i++]);m.put("averageSalary",row[i]);result.add(m);}
  return result;
 }
}
