package com.acme.salary.dto;
import com.acme.salary.entity.Employee;
import java.math.BigDecimal;
import java.time.Instant;
public record EmployeeResponse(Long id,String employeeCode,String firstName,String lastName,String email,
 String country,String department,String jobTitle,BigDecimal salaryAmount,String currencyCode,Instant createdAt,Instant updatedAt) {
 public static EmployeeResponse from(Employee e){return new EmployeeResponse(e.getId(),e.getEmployeeCode(),e.getFirstName(),e.getLastName(),e.getEmail(),e.getCountry(),e.getDepartment(),e.getJobTitle(),e.getSalaryAmount(),e.getCurrencyCode(),e.getCreatedAt(),e.getUpdatedAt());}
}
