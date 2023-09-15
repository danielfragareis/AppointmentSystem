/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senacead.atividade03.model;

/**
 *
 * @author danie
 */
public class Appointment {
    private String pacientName;
    private String pacientCpf;
    private String pacientPhone;
    private String appointmentDate;
    private String isPacient;
    private String appointmentCompleted;
    private String appointmentDetails;

    public Appointment(){
        
    }
    
    public String getPacientName() {
        return pacientName;
    }

    public void setPacientName(String pacientName) {
        this.pacientName = pacientName;
    }

    public String getPacientCpf() {
        return pacientCpf;
    }

    public void setPacientCpf(String pacientCpf) {
        this.pacientCpf = pacientCpf;
    }

    public String getPacientPhone() {
        return pacientPhone;
    }

    public void setPacientPhone(String pacientPhone) {
        this.pacientPhone = pacientPhone;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getIsPacient() {
        return isPacient;
    }

    public void setIsPacient(boolean alreadyPacient) {
        if (alreadyPacient){
            this.isPacient = "Sim";
        } else {
            this.isPacient = "Não";
        }
    }

    public String getAppointmentCompleted() {
        return appointmentCompleted;
    }

    public void setAppointmentCompleted(String appointmentCompleted) {
        this.appointmentCompleted = appointmentCompleted;
    }

    public String getAppointmentDetails() {
        return appointmentDetails;
    }

    public void setAppointmentDetails(String appointmentDetails) {
        this.appointmentDetails = appointmentDetails;
    }

    @Override
    public String toString() {
        return "Appointment{" + "pacientName=" + pacientName + ", pacientCpf=" + pacientCpf + ", pacientPhone=" + pacientPhone + ", appointmentDate=" + appointmentDate + ", isPacient=" + isPacient + ", appointmentCompleted=" + appointmentCompleted + ", appointmentDetails=" + appointmentDetails + '}';
    }

    
}
