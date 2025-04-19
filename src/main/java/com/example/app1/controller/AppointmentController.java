package com.example.app1.controller;

import com.example.app1.dto.AppointmentDto;
import com.example.app1.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/create")
    public String createAppointment(@RequestBody AppointmentDto appointmentDto) {
        return appointmentService.createAppointment(appointmentDto);
    }

    @GetMapping("/get/{id}")
    public AppointmentDto getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    @PutMapping("/update/{id}")
    public String updateAppointment(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto) {
        return appointmentService.updateAppointment(id, appointmentDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        return appointmentService.deleteAppointment(id);
    }
}
