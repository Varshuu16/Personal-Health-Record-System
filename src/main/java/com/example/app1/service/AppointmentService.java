package com.example.app1.service;

import com.example.app1.dto.AppointmentDto;

public interface AppointmentService {
    String createAppointment(AppointmentDto appointmentDto);
    AppointmentDto getAppointment(Long id);
    String updateAppointment(Long id, AppointmentDto appointmentDto);
    String deleteAppointment(Long id);
}
