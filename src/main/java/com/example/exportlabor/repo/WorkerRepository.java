package com.example.exportlabor.repo;

import com.example.exportlabor.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WorkerRepository extends JpaRepository<Worker, Long> {


    @Modifying
    @Query(value =
            "INSERT INTO [dbo].[worker]" +
            "           ([desired_salary]" +
            "           ,[dob]" +
            "           ,[education]" +
            "           ,[gender]" +
            "           ,[skill]" +
            "           ,[work_experience]" +
            "           ,[worker_id])" +
            "     VALUES (:#{#worker.desiredSalary},:#{#worker.dob},:#{#worker.education},:#{#worker.gender},:#{#worker.skill},:#{#worker.workExperience},:#{#worker.userId},)" , nativeQuery = true)
    void customInsertWithObject(@Param("worker") Worker worker);


}
