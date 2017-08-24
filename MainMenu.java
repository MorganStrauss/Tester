import java.util.*;
import java.io.*;
public class MainMenu {
    public static void main(String a[]) throws IOException{
        Scanner person = new Scanner(System.in);
        String compAnwser = "";
        boolean running = true;
        
        
        
        while(running) {
            System.out.println("                     ||||     ||||||     ||||||||     ||||  ||||    ");
            System.out.println("                      ||     ||    ||     ||    ||     ||    ||     ");
            System.out.println("                      ||     ||    ||     ||    ||     ||   ||      ");
            System.out.println("                ||    ||     ||    ||     |||||||      ||||||       ");
            System.out.println("                ||    ||     ||    ||     ||    ||     ||   ||      ");
            System.out.println("                 ||||||       ||||||     ||||  ||||   ||||  ||||    ");
            System.out.println("                                                                    ");
            System.out.println("             -------------------------------------------------------");
            System.out.println("             |                     New Game                        |");
            System.out.println("             |                     Continue                        |");
            System.out.println("             |                      Extras                         |");
            System.out.println("             |                       Quit                          |");
            System.out.println("             -------------------------------------------------------");

            System.out.println(compAnwser); //Computer Anwser

            System.out.print(">");
            String anwser = person.nextLine();
            switch(anwser) {
                case "New Game":
                case "new game":
                case "NewGame":
                case "newgame":
                System.out.print("\u000c");
                new UserInt();
                break;
                case "Quit":
                case "quit":
                running = false;
                break;
                default:
                System.out.print("\u000c");
                compAnwser = "That is not an Option!";
            }

        }
    }
}