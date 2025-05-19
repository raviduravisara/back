package com.SalonManagement.service;


import com.SalonManagement.model.Schedule;
import com.SalonManagement.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getScheduleByEmployeeId(Long employeeId) {
        return scheduleRepository.findByEmployeeId(employeeId);
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .orElse(null);
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Long id, Schedule scheduleDetails) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElse(null);
        if (schedule != null) {
            schedule.setDay(scheduleDetails.getDay());
            schedule.setStartTime(scheduleDetails.getStartTime());
            schedule.setEndTime(scheduleDetails.getEndTime());
            schedule.setEmployee(scheduleDetails.getEmployee());
            return scheduleRepository.save(schedule);
        }
        return null;
    }
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }





























}
