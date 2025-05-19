package com.SalonManagement.repository;

import com.SalonManagement.model.PerformanceMetric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceRepository extends JpaRepository<PerformanceMetric, Long> {
    List<PerformanceMetric> findByEmployeeId(long employeeId);
}
