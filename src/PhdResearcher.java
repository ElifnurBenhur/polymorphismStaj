import java.util.Random;

public class PhdResearcher extends ProjectBasedWorker{
      private String name;
      private String surName;
      private int researcherID;
      private Project rProject;
      private int score;


    public PhdResearcher(String name, String surName, int researcherID) {
        this.name = name;
        this.surName = surName;
        this.researcherID = researcherID;
        this.rProject=new Project("Analysis of senescence signals from cancer cells","2 TERMS");
        this.score=0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getResearcherID() {
        return researcherID;
    }


    public void setResearcherID(int researcherID) {
        this.researcherID = researcherID;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public  boolean signToProject(){
        System.out.println("You signed into project:"+rProject.toString());
        super.sign=true;
        this.score=10;
        return true;
    }




    @Override
    public void viewOptions() {
        System.out.print("You can choose actions. Please enter actions with one space. Available actions are;\n" +
                "You can take shift at lab with: 'shift'\n" +
                "You can start project with: 'signToP'\n" +
                "You can deliver your midterm report for project with: 'mid'\n" +
                "You can deliver your final report for project with: 'final'\n" +
                "You can check your project progress with: 'check'\n" +
                "!!!!!!WARNINGS!!!!!!\n" +
                "You have to assign to project, deliver your midterm and final reports of your project in order to win!\n" +
                "Also, You have to take at least 8 shifts and check your project at least 8 times!\n " );

    }
    public void takeAction(String c,int i){
         if(c.equals("shift")){
            super.takeShift();
        }
        else if(c.equals("signToP")){
            this.signToProject();
        }
        else if(c.equals("mid")){
            super.assignMidReport();
        }
        else if(c.equals("final")){
            super.assignFinalReport();
        }
        else if(c.equals("check")){
            super.checkProject();
        }
        else{
            System.out.println("Not a valiable action!");
         }
    }
    public String toString(){
        return "Researcher Name:"+this.getName()+" "+this.getSurName()+"\nResearcher ID:"+this.getResearcherID()+"\nResearcher Score:"+this.score+"\n";
    }


}
