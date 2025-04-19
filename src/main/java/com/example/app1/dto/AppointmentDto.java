package com.example.app1.dto;
import java.util.Date;
public class AppointmentDto {
    private Long appointmentID;
    private Date appointmentDate;
    private String details;
    public Long getAppointmentID() {
        return appointmentID;
    }
    public void setAppointmentID(Long appointmentID) {
        this.appointmentID = appointmentID;
    }
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
}
