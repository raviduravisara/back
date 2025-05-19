package com.SalonManagement.controller;


import com.SalonManagement.model.PerformanceMetric;
import com.SalonManagement.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performances")
@CrossOrigin
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping
    public List<PerformanceMetric>getAllPerformances(){
        return performanceService.getAllPerformance();
    }

    @GetMapping("/employee/{employeeId}")
    public List<PerformanceMetric>getPerformancesByEmployee(@PathVariable Long employeeId){
        return performanceService.getPerformanceByEmployeeId(employeeId);
    }

    @GetMapping("/{id}")
    public PerformanceMetric getPerformanceById(@PathVariable Long id){
        return performanceService.getPerformanceById(id);
    }


    @PostMapping
    public PerformanceMetric createPerformance(@RequestBody PerformanceMetric performance){
        return performanceService.savePerformance(performance);
    }

    @PutMapping
    public PerformanceMetric updatePerformance(@PathVariable Long id, @RequestBody PerformanceMetric performance){
        return performanceService.updatePerformance(id, performance);
    }

    @DeleteMapping("/{id}")
    public void deletePerformance(@PathVariable Long id){
        performanceService.deletePerformance(id);
    }







}
