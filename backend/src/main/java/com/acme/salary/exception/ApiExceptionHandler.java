package com.acme.salary.exception;
import com.acme.salary.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(ResourceNotFoundException.class) ResponseEntity<Map<String,Object>> missing(RuntimeException e){return body(HttpStatus.NOT_FOUND,e.getMessage());}
 @ExceptionHandler(DuplicateEmployeeException.class) ResponseEntity<Map<String,Object>> duplicate(RuntimeException e){return body(HttpStatus.CONFLICT,e.getMessage());}
 @ExceptionHandler(IllegalArgumentException.class) ResponseEntity<Map<String,Object>> invalid(RuntimeException e){return body(HttpStatus.BAD_REQUEST,e.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException e){
  Map<String,String> fields=new LinkedHashMap<>();e.getBindingResult().getFieldErrors().forEach(x->fields.putIfAbsent(x.getField(),x.getDefaultMessage()));
  Map<String,Object> b=new LinkedHashMap<>();b.put("status",400);b.put("error","Validation failed");b.put("fields",fields);return ResponseEntity.badRequest().body(b);
 }
 private ResponseEntity<Map<String,Object>> body(HttpStatus s,String m){Map<String,Object>b=new LinkedHashMap<>();b.put("status",s.value());b.put("error",s.getReasonPhrase());b.put("message",m);return ResponseEntity.status(s).body(b);}
}
