package com.acme.salary.dto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
public record EmployeeRequest(
 @NotBlank @Size(max=30) String employeeCode,
 @NotBlank @Size(max=80) String firstName,
 @NotBlank @Size(max=80) String lastName,
 @NotBlank @Email @Size(max=180) String email,
 @NotBlank @Size(max=80) String country,
 @NotBlank @Size(max=80) String department,
 @NotBlank @Size(max=100) String jobTitle,
 @NotNull @DecimalMin(value="0.00", inclusive=false) @Digits(integer=17,fraction=2) BigDecimal salaryAmount,
 @NotBlank @Pattern(regexp="^[A-Za-z]{3}$", message="must be a 3-letter currency code") String currencyCode
) {}
