/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senacead.atividade03.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danie
 */
public class AppointmentList {
    private static final List<Appointment> list = new ArrayList<>();
    
    public static List<Appointment> listAll(){
        return list;
    }
    
}
