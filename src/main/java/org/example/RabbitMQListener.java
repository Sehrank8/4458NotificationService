package org.example;

import org.example.model.Job;
import org.example.service.AlertService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {
    private final AlertService alertService;

    public RabbitMQListener(AlertService alertService) {
        this.alertService = alertService;
    }

    @RabbitListener(queues = "${job.queue.name}", ackMode = "AUTO")
    public void receive(Job job) {
        if (job == null || job.getTitle() == null || job.getCity() == null) {
            System.out.println("Skipping malformed job message.");
            return;
        }
        System.out.println("Received new job: " + job.getTitle() + " in " + job.getCity());
        alertService.checkAndNotify(job);
    }

}
