package com.acme.salary.controller;
import com.acme.salary.service.AnalyticsService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/analytics") @CrossOrigin(origins="${FRONTEND_ORIGIN:http://localhost:5173}")
public class AnalyticsController {
 private final AnalyticsService service;
 public AnalyticsController(AnalyticsService service){this.service=service;}
 @GetMapping("/summary") public Map<String,Object> summary(){return service.summary();}
}
