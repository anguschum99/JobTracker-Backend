package angus.JobTracker.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String jobName;
    private String jobRole;
    private String screenshot;
    private String date;


    public Job(){}

    public Job(String jobName, String jobRole, String screenshot, String date){
        this.jobName=jobName;
        this.jobRole=jobRole;
        this.screenshot=screenshot;
        this.date=date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long jobId) {
        this.id = jobId;
    }

    public String getJobRole() {
        return jobRole;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    @Override
    public String toString(){
        return "Employee{" +
                "id=" + id +
                ", Job Name='" + jobName + '\'' +
                ", Job Role='" + jobRole + '\'' +
                ", Screenshot='" + screenshot + '\''+
                ", Date='" + date + '\'' +
                '}';
    }
}
