package org.example.service;

import org.example.model.Job;
import org.example.model.JobAlert;
import org.example.repository.JobAlertRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {
    private final JobAlertRepository alertRepo;

    public AlertService(JobAlertRepository repo) {
        this.alertRepo = repo;
    }

    public JobAlert addAlert(JobAlert alert) {
        return alertRepo.save(alert);
    }

    public List<JobAlert> getAlertsForUser(String userId) {
        return alertRepo.findByUserId(userId);
    }

    public void checkAndNotify(Job job) {
        JobAlert jobAlert = new JobAlert();
        jobAlert.setCity(job.getCity());
        jobAlert.setTitle(job.getTitle());
        jobAlert.setUserId("1");
        addAlert(jobAlert);
        List<JobAlert> alerts = alertRepo.findByCityAndTitleIgnoreCase(job.getCity(), job.getTitle());
        for (JobAlert alert : alerts) {

            System.out.println("Notify user " + alert.getUserId() + ": New job match → " + job.getTitle());
        }
    }
}
