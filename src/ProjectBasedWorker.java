public abstract class ProjectBasedWorker implements Worker {

    protected boolean sign=false;
    protected boolean mid=false;
    protected boolean finR=false;
    protected int checkP=0;
    protected int shift=0;

    public boolean checkProject(){
        checkP++;
        System.out.println("You checked your project "+checkP+". times.");
        return true;
    }
    public boolean assignMidReport(){
        if(this.shift>3) {
            System.out.println("You assigned your midterm report.");
            mid=true;
        }
        else{
            System.out.println("Your process is not enough for delievering midterm report.");
        }

        return true;
    }
    public boolean assignFinalReport(){
        if(this.shift>7) {
            System.out.println("You assigned your final report.");
            finR = true;
        }
        else {
            System.out.println("Your process is not enough for delievering final report.");
        }
        return true;
    }
    public boolean takeShift(){
        shift++;
        System.out.println("You took your "+shift+ ".shift at lab.");
        return true;
    }

    public boolean isSign() {
        return sign;
    }

    public boolean isMid() {
        return mid;
    }

    public boolean isFinR() {
        return finR;
    }

    public int getCheckP() {
        return checkP;
    }

    public int getShift() {
        return shift;
    }


    public abstract void takeAction(String c,int i);
}
