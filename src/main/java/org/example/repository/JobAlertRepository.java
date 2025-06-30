package org.example.repository;

import org.example.model.JobAlert;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JobAlertRepository extends MongoRepository<JobAlert, String> {
    List<JobAlert> findByCityAndTitleIgnoreCase(String city, String title);
    List<JobAlert> findByUserId(String userId);
}
