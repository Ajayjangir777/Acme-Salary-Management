package com.acme.salary.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name="employees", indexes={
 @Index(name="idx_employee_code", columnList="employee_code", unique=true),
 @Index(name="idx_country_department", columnList="country,department")
})
public class Employee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="employee_code", nullable=false, unique=true, length=30) private String employeeCode;
 @Column(nullable=false, length=80) private String firstName;
 @Column(nullable=false, length=80) private String lastName;
 @Column(nullable=false, unique=true, length=180) private String email;
 @Column(nullable=false, length=80) private String country;
 @Column(nullable=false, length=80) private String department;
 @Column(nullable=false, length=100) private String jobTitle;
 @Column(nullable=false, precision=19, scale=2) private BigDecimal salaryAmount;
 @Column(nullable=false, length=3) private String currencyCode;
 @Column(nullable=false, updatable=false) private Instant createdAt;
 @Column(nullable=false) private Instant updatedAt;
 @PrePersist void createTimestamps(){createdAt=Instant.now();updatedAt=createdAt;}
 @PreUpdate void updateTimestamp(){updatedAt=Instant.now();}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getEmployeeCode(){return employeeCode;} public void setEmployeeCode(String v){employeeCode=v;}
 public String getFirstName(){return firstName;} public void setFirstName(String v){firstName=v;}
 public String getLastName(){return lastName;} public void setLastName(String v){lastName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getCountry(){return country;} public void setCountry(String v){country=v;}
 public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
 public String getJobTitle(){return jobTitle;} public void setJobTitle(String v){jobTitle=v;}
 public BigDecimal getSalaryAmount(){return salaryAmount;} public void setSalaryAmount(BigDecimal v){salaryAmount=v;}
 public String getCurrencyCode(){return currencyCode;} public void setCurrencyCode(String v){currencyCode=v;}
 public Instant getCreatedAt(){return createdAt;} public Instant getUpdatedAt(){return updatedAt;}
}
