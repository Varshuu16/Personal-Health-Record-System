package com.example.app1.serviceimpl;

import com.example.app1.dto.AppointmentDto;
import com.example.app1.entity.Appointment;
import com.example.app1.repository.AppointmentRepository;
import com.example.app1.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public String createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setDetails(appointmentDto.getDetails());
        appointmentRepository.save(appointment);
        return "Appointment created successfully";
    }

    @Override
    public AppointmentDto getAppointment(Long id) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            AppointmentDto appointmentDto = new AppointmentDto();
            appointmentDto.setAppointmentID(appointment.getAppointmentID());
            appointmentDto.setAppointmentDate(appointment.getAppointmentDate());
            appointmentDto.setDetails(appointment.getDetails());
            return appointmentDto;
        } else {
            throw new RuntimeException("Appointment not found");
        }
    }

    @Override
    public String updateAppointment(Long id, AppointmentDto appointmentDto) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
            appointment.setDetails(appointmentDto.getDetails());
            appointmentRepository.save(appointment);
            return "Appointment updated successfully";
        } else {
            return "Appointment not found";
        }
    }

    @Override
    public String deleteAppointment(Long id) {
        if (appointmentRepository.existsById(id)) {
            appointmentRepository.deleteById(id);
            return "Appointment deleted successfully";
        } else {
            return "Appointment not found";
        }
    }
}
