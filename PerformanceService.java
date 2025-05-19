package com.SalonManagement.service;


import com.SalonManagement.model.PerformanceMetric;
import com.SalonManagement.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceService {
    @Autowired
    private PerformanceRepository performanceRepository;

    public List<PerformanceMetric> getAllPerformance() {
        return performanceRepository.findAll();
    }

    public List<PerformanceMetric> getPerformanceByEmployeeId(Long employeeId) {
        return performanceRepository.findByEmployeeId(employeeId);
    }

    public PerformanceMetric getPerformanceById(Long id){
        return performanceRepository.findById(id)
                .orElse(null);
    }

    public PerformanceMetric savePerformance(PerformanceMetric performance) {
        return performanceRepository.save(performance);
    }

    public PerformanceMetric updatePerformance(Long id, PerformanceMetric performanceDetail) {
        PerformanceMetric performance = performanceRepository.findById(id)
                .orElse(null);
        if (performance != null) {
            performance.setClientServed((performanceDetail.getClientServed()));
            performance.setRevenue((performanceDetail.getRevenue()));
            performance.setRating((performanceDetail.getRating()));
            performance.setRecordDate((performanceDetail.getRecordDate()));
            performance.setEmployee(performanceDetail.getEmployee());
            return performanceRepository.save(performance);
        }
        return null;
    }
    public void deletePerformance(Long id) {
        performanceRepository.deleteById(id);
    }
































}
