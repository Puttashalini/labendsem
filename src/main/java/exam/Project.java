package exam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    private int duration;
    private double budget;

    @Column(name = "team_lead")
    private String teamLead;

    public Project() {}
    public Project(String projectName, int duration, double budget, String teamLead) {
        this.projectName = projectName;
        this.duration = duration;
        this.budget = budget;
        this.teamLead = teamLead;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    public String getTeamLead() { return teamLead; }
    public void setTeamLead(String teamLead) { this.teamLead = teamLead; }
}
