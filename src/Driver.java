/*
This is the driver class to run!
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Driver {

    public static void main(String[] args) {

        Lecture[] lec = new Lecture[8];
        ArrayList<String> months = new ArrayList<String>(8);
        String mode = "", name = "", surName = "", choice = "";
        Random rID = new Random();
        Scanner in = new Scanner(System.in);

        months.add("***MARCH***\n");
        months.add("***APRIL***\n");
        months.add("***MAY***\n");
        months.add("***JUNE***\n");
        months.add("***SEPTEMBER***\n");
        months.add("***OCTOBER***\n");
        months.add("***NOVEMBER***\n");
        months.add("***DECEMBER***\n");

        lec[0] = new Lecture("Applied Pharmacology", "Selma Kılıç", "GUZ", 6);
        lec[1] = new Lecture("Cell Biology", "Şeyda Demir", "GUZ", 5);
        lec[2] = new Lecture("The Epigenetic of Cancer", "Murat Kaya", "GUZ", 5);
        lec[3] = new Lecture("Cellular Life Cycle", "Selma Kılıç", "GUZ", 4);
        lec[4] = new Lecture("Applied Pharmacology 2", "Selma Kılıç", "BAHAR", 6);
        lec[5] = new Lecture("Biochemistry", "Şeyda Demir", "BAHAR", 5);
        lec[6] = new Lecture("Neurochemistry", "Murat Kaya", "BAHAR", 5);
        lec[7] = new Lecture("Protein-Protein Interactions", "Selma Kılıç", "BAHAR", 4);

        System.out.println("****Welcome To Scientist Simulator****");
        System.out.println("Please enter your name and surname with one space!");
        name = in.next();
        surName = in.next();
        System.out.println("Please select a game mode!\n Press E for easy mode and N for nightmare mode");
        mode = in.next();
        Worker w = new LabAssistant();
        if (mode.equals("E")) {
            System.out.println("You choosed easy mode!\n You are a PHD Researcher.\n");
            w = new PhdResearcher(name, surName, rID.nextInt(100)+900);
            System.out.print("You succesfully enrolded as\n"+((PhdResearcher)w).toString());
            ((PhdResearcher)w).viewOptions();

        } else if (mode.equals("N")) {
            System.out.println("You choosed NIGHTMARE mode!\n You are a Laborotory Assistent :( .\n");
            w = new LabAssistant(name, surName, rID.nextInt(100)+900, lec);
            System.out.print("You succesfully enrolded as\n"+((LabAssistant)w).toString());
            ((LabAssistant)w).viewOptions();

        }else{
            System.out.println("You entered an invalid action");
            System.exit(0);
        }
        System.out.println("You want to start a new project");

        System.out.println("To do that you have 8 months composed of two semesters(4 months each)");
            System.out.println("You have to make right choices to succesfully complete it .\n");
            System.out.println("You can choose three actions each month. If you can achieve 10 points of score " +
                    " You are going to WIN!\nEnter 'EX' to exit.\n!!! GOOD LUCKS!!! ");
            //Loop to cover all months.
            for(int i=0;i<8;i++){

                System.out.println(months.get(i));
                //Loop to take three actions
                for(int j=0;j<3;j++) {
                    System.out.println((j+1)+". Action of "+months.get(i)+":");
                    choice = in.next();
                    if(choice.equals("EX")){
                        System.out.println("Oyundan çıkılıyor...");
                        System.exit(0);
                    }
                    else if (mode.equals("N")) {
                        ((LabAssistant) w).takeAction(choice,i);
                    }
                    else if (mode.equals("E")) {
                        ((PhdResearcher) w).takeAction(choice,i);
                    }
                }
            }
            System.out.println("Your time for the project is up!\n Lets check your status");
        if(mode.equals("N")){
           System.out.println (""+((LabAssistant) w).toString());

        }
        else if (mode.equals("E")) {
            System.out.println(""+((PhdResearcher) w).toString());
        }
        if(((ProjectBasedWorker) w).isSign()){
            System.out.println("You started your project!");
        }
        if(((ProjectBasedWorker) w).isMid()){
            System.out.println("You delivered your midterm report for the project.");
        }
        if(((ProjectBasedWorker) w).isFinR()){
            System.out.println("You delivered your final report for the project.");
        }
        System.out.println("You took "+((ProjectBasedWorker) w).getShift()+" shifts.");
        System.out.println("You check your project "+((ProjectBasedWorker) w).getCheckP()+" times.");
            if(((ProjectBasedWorker) w).isFinR()&((ProjectBasedWorker) w).isMid()&((ProjectBasedWorker) w).isSign()&((ProjectBasedWorker) w).getCheckP()>=8&((ProjectBasedWorker) w).getShift()>=8){
                System.out.print("!YOU COMPLETED PROJECT SUCCESSFULLY!");
                if(mode.equals("E")){
                    if(((PhdResearcher) w).getScore()>=10){
                        System.out.println("YOU REACHED THE NECESSARY SCORE.\n !!!YOU WON THE GAME!!!");
                    }
                    else{
                        System.out.println("You are under the necessary score. !!!YOU LOST!!!");
                    }
                }
                if(mode.equals("N")){
                    if(((LabAssistant) w).getScore()>=10){
                        System.out.println("YOU REACHED THE NECESSARY SCORE.\n !!!YOU WON THE GAME!!!");
                    }
                    else{
                        System.out.println("You are under the necessary score. !!!YOU LOST!!!");
                    }
                }
            }
            else{
                System.out.print("!YOU COULD NOT DO EVEN THE NECESSARY ACTIONS!\n !!YOU FAIL AND LOST!!\n");
            }

    }
}
