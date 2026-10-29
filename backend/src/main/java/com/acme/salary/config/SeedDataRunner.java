package com.acme.salary.config;
import com.acme.salary.entity.Employee;
import com.acme.salary.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.*;
@Component
public class SeedDataRunner implements CommandLineRunner {
 private final EmployeeRepository repo;
 @Value("${app.seed-enabled:true}") private boolean enabled;
 private final String[] first={"Aarav","Asha","Rohan","Priya","Ishaan","Maya","Noah","Olivia"};
 private final String[] last={"Sharma","Patel","Singh","Gupta","Mehta","Brown","Wilson","Khan"};
 private final String[] countries={"India","United States","United Kingdom","Germany","Singapore","Canada"};
 private final String[] currencies={"INR","USD","GBP","EUR","SGD","CAD"};
 private final String[] departments={"Engineering","Product","Finance","Human Resources","Sales","Operations","Design","Marketing"};
 public SeedDataRunner(EmployeeRepository repo){this.repo=repo;}
 @Override @Transactional public void run(String... args){
  if(!enabled||repo.count()>0)return;
  Random random=new Random(20261029L);List<Employee> batch=new ArrayList<>(500);
  for(int i=1;i<=10000;i++){Employee e=new Employee();int c=(i-1)%countries.length;
   e.setEmployeeCode(String.format(Locale.ROOT,"ACME-%05d",i));e.setFirstName(first[(i-1)%first.length]);e.setLastName(last[(i*3)%last.length]);
   e.setEmail("employee"+i+"@example.com");e.setCountry(countries[c]);e.setCurrencyCode(currencies[c]);
   e.setDepartment(departments[(i*3)%departments.length]);e.setJobTitle("Specialist");
   e.setSalaryAmount(BigDecimal.valueOf(35000+random.nextInt(165000)).setScale(2));batch.add(e);
   if(batch.size()==500){repo.saveAll(batch);repo.flush();batch.clear();}
  }if(!batch.isEmpty())repo.saveAll(batch);
 }
}
