import java.util.Random;
public class LabAssistant extends ProjectBasedWorker implements Student{
    private String name;
    private String surName;
    private int assistantID;
    private Lecture[] aLecture;
    private Project aProject;
    private int score;
    private int exp;
    private Random rA;


    public LabAssistant(){

    }
    public LabAssistant(String name, String surName, int assistantID,Lecture[] aLecture) {

        this.name = name;
        this.surName = surName;
        this.assistantID = assistantID;
        this.aLecture=aLecture;
        this.aProject=new Project("Apoptosis Induction by ExtraCellular Signals","2 TERMS");
        this.score=0;
        this.exp=0;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
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

    public int getAssistantID() {
        return assistantID;
    }


    public void setAssistantID(int assistantID) {
        this.assistantID = assistantID;
    }


    public  boolean signToProject(){
        System.out.println("You signed into project:"+aProject.toString());
        super.sign=true;
        return true;
    }
    @Override
    public boolean studyLecture(int i) {
        int lectureIndex=0;
        rA = new Random();
        if(i<4) {

            lectureIndex=rA.nextInt(4)+4;
        }
        else if(i>3){
            lectureIndex=rA.nextInt(4);
        }
        System.out.println("You studied "+aLecture[lectureIndex].toString());
        this.exp++;
        return true;
    }

    @Override
    public boolean takeExam(int i) {
        int lectureIndex=0;
        rA = new Random();
        if(i<4) {

            lectureIndex=rA.nextInt(4)+4;
        }
        else if(i>3){
            lectureIndex=rA.nextInt(4);
        }
        System.out.println("You took the exam "+aLecture[lectureIndex].toString());
        if (this.exp>2){
            System.out.println("!!CONGRATS!!\n You passed the exam :) ");
            this.score=score+5;
        }else{
            System.out.println("!!SORRY!!\n You FAILED at the exam since you did not study enough :( ");
            this.score=score-3;
        }
        return true;
    }

    @Override
    public boolean deliverAssignment(int i) {
        int lectureIndex=0;
        rA = new Random();
        if(i<4) {

            lectureIndex=rA.nextInt(4)+4;
        }
        else if(i>3){
            lectureIndex=rA.nextInt(4);
        }
        System.out.println("You took the exam "+aLecture[lectureIndex].toString());
        if (this.exp>2){
            System.out.println("!!CONGRATS!!\n Your assignment welcomed by Proffesor "+aLecture[lectureIndex].getLectureInstructor()+":)");
            this.score=score+5;
        }else{
            System.out.println("!!SORRY!!\n Proffesor "+aLecture[lectureIndex].getLectureInstructor()+"became mad of your assignment, telling you that  your work is a mess since you did not study enough:(");
            this.score=score-3;
        }
        return false;
    }

    @Override
    public boolean takeLecture(int i) {
        int lectureIndex=0;
        rA = new Random();
        if(i<4) {

            lectureIndex=rA.nextInt(4)+4;
        }
        else if(i>3){
            lectureIndex=rA.nextInt(4);
        }
        System.out.println("You took classes of  "+aLecture[lectureIndex].toString());
        this.exp++;
        return true;
    }
     public void viewOptions(){
      System.out.print("You can choose actions. Available actions are;\n" +
              "You can take classes with: 'lesson'\n" +
              "You can study to the lessons with: 'study'\n" +
              "You can take exams with: 'exam'\n" +
              "You can deliver assignment with:'assignment'\n" +
              "You can take shift at lab with: 'shift'\n" +
              "You can start project with: 'signToP'\n" +
              "You can deliver your midterm report for project with: 'mid'\n" +
              "You can deliver your final report for project with: 'final'\n" +
              "You can check your project progress with: 'check'\n" +
              "!!!!!!WARNINGS!!!!!!\n" +
              "You have to assign to project, deliver your midterm and final reports of your project in order to win!\n" +
              "Also, You have to take at least 8 shifts and check your project at least 8 times!\n " +
              "You can loose points by taking exams and delivering assignments if you did not study!\n" +
              "However you score more with these options if you have studied enough!\n");
     }

     public void takeAction(String c,int i){
        if(c.equals("lesson")){
            this.takeLecture(i);
        }
        else if(c.equals("study")){
            this.studyLecture(i);
        }
        else if(c.equals("exam")){
            this.takeExam(i);
        }
        else if(c.equals("assignment")){
            this.deliverAssignment(i);
        }
        else if(c.equals("shift")){
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
        return "Asistan Name:"+this.name+" "+this.surName+"\nAsistant ID:"+this.assistantID+"\nAsistant Score:"+this.score+"\nAsistant Experience:"+this.exp+"\n";
     }

}
