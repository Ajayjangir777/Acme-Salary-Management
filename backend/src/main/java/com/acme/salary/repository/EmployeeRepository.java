package com.acme.salary.repository;
import com.acme.salary.entity.Employee;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
 boolean existsByEmployeeCodeIgnoreCase(String code);
 boolean existsByEmailIgnoreCase(String email);
 Optional<Employee> findByEmployeeCodeIgnoreCase(String code);
 @Query("select e from Employee e where (:search = '' or lower(e.employeeCode) like lower(concat('%',:search,'%')) or lower(e.firstName) like lower(concat('%',:search,'%')) or lower(e.lastName) like lower(concat('%',:search,'%'))) and (:country = '' or lower(e.country)=lower(:country)) and (:department = '' or lower(e.department)=lower(:department))")
 Page<Employee> search(@Param("search") String search,@Param("country") String country,@Param("department") String department,Pageable pageable);
 @Query("select e.currencyCode, count(e), sum(e.salaryAmount), avg(e.salaryAmount) from Employee e group by e.currencyCode order by e.currencyCode")
 List<Object[]> summaryByCurrency();
 @Query("select e.country, e.currencyCode, count(e), sum(e.salaryAmount), avg(e.salaryAmount) from Employee e group by e.country,e.currencyCode order by e.country,e.currencyCode")
 List<Object[]> summaryByCountryCurrency();
 @Query("select e.department, e.currencyCode, count(e), sum(e.salaryAmount), avg(e.salaryAmount) from Employee e group by e.department,e.currencyCode order by e.department,e.currencyCode")
 List<Object[]> summaryByDepartmentCurrency();
}
