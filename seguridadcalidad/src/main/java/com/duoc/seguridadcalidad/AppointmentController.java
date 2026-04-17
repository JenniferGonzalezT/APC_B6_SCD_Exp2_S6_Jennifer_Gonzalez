package com.duoc.seguridadcalidad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

    @GetMapping("/appointments")
    public String listAppointments() {
        return "appointments";
    }

    @GetMapping("/appointments/new")
    public String showCreateForm() {
        return "new_appointment";
    }

    @PostMapping("/appointments")
    public String saveAppointment() {
        return "redirect:/appointments";
    }
}
