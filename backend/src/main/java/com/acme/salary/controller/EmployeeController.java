package com.acme.salary.controller;
import com.acme.salary.dto.*;
import com.acme.salary.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/employees")
@CrossOrigin(origins="${FRONTEND_ORIGIN:http://localhost:5173}")
public class EmployeeController {
 private final EmployeeService service;
 public EmployeeController(EmployeeService service){this.service=service;}
 @GetMapping public Page<EmployeeResponse> list(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="20") int size,@RequestParam(defaultValue="") String search,@RequestParam(defaultValue="") String country,@RequestParam(defaultValue="") String department){return service.list(page,size,search,country,department);}
 @GetMapping("/{id}") public EmployeeResponse get(@PathVariable long id){return service.get(id);}
 @PostMapping public EmployeeResponse create(@Valid @RequestBody EmployeeRequest r){return service.create(r);}
 @PutMapping("/{id}") public EmployeeResponse update(@PathVariable long id,@Valid @RequestBody EmployeeRequest r){return service.update(id,r);}
}
