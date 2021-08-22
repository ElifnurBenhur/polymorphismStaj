

public class Lecture {
    private String lectureName;
    private String lectureInstructor;
    private String lectureTerm;
    private int lectureAKTS;

    public Lecture(String lectureName, String lectureInstructor, String lectureTerm, int lectureAKTS) {
        this.lectureName = lectureName;
        this.lectureInstructor = lectureInstructor;
        this.lectureTerm = lectureTerm;
        this.lectureAKTS = lectureAKTS;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureInstructor() {
        return lectureInstructor;
    }

    public void setLectureInstructor(String lectureInstructor) {
        this.lectureInstructor = lectureInstructor;
    }

    public String getLectureTerm() {
        return lectureTerm;
    }

    public void setLectureTerm(String lectureTerm) {
        this.lectureTerm = lectureTerm;
    }

    public int getLectureAKTS() {
        return lectureAKTS;
    }

    public void setLectureAKTS(int lectureAKTS) {
        this.lectureAKTS = lectureAKTS;
    }

    public String toString(){
        return "lecture named "+this.getLectureName()+ " having "+this.getLectureAKTS()+
                " AKTS,\n given by "+this.getLectureInstructor()+" at "+this.getLectureTerm()+ " TERM\n";
    }
}
