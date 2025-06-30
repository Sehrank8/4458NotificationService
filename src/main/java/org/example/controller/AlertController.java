package org.example.controller;


import org.example.model.JobAlert;
import org.example.service.AlertService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alerts")
public class AlertController {
    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public JobAlert addAlert(@RequestBody JobAlert alert) {
        return alertService.addAlert(alert);
    }

    @GetMapping
    public List<JobAlert> getAlerts(@RequestParam String userId) {
        return alertService.getAlertsForUser(userId);
    }
}
