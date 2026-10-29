package com.acme.salary.service;
import com.acme.salary.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class EmployeeServiceTest {
 private final EmployeeRepository repo=mock(EmployeeRepository.class);
 private final EmployeeService service=new EmployeeService(repo);
 @Test void rejectsNegativePage(){assertThrows(IllegalArgumentException.class,()->service.list(-1,20,"","",""));}
 @Test void rejectsOversizedPage(){assertThrows(IllegalArgumentException.class,()->service.list(0,101,"","",""));}
 @Test void missingEmployeeReturnsNotFound(){when(repo.findById(77L)).thenReturn(java.util.Optional.empty());assertThrows(ResourceNotFoundException.class,()->service.get(77L));}
}
