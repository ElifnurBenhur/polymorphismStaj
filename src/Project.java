import java.util.Random;

public class Project {
    private String projectName;
    private String projectDuration;
    private int projectID;


    public Project() {
        this.projectDuration="2 Terms";
        this.projectID=5000674;
        this.projectName="";
    }

    public Project(String projectName, String projectDuration) {
        this.projectName = projectName;
        this.projectDuration = projectDuration;
        Random r=new Random();
        this.projectID = r.nextInt(1000)+9000;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDuration() {
        return projectDuration;
    }

    public void setProjectDuration(String projectDuration) {
        this.projectDuration = projectDuration;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String toString(){
        return "You assigned to the project named "+this.getProjectName()+" is accepted and has the ID:"
                +this.getProjectID()+" is going to remain for "+this.projectDuration+"\n";
    }
}
