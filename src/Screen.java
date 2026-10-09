import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.awt.Desktop;
import java.io.IOException;


public class Screen {
    
    public Screen(){}

    // MENU DISPLAY
    public void displayMenu() throws FileNotFoundException, IOException{
        File aniStat = new File(".txt/Anistat.txt");
        PrintWriter display = new PrintWriter(aniStat);

        display.println("^-^-^-^-^-^ ANISTAT ^-^-^-^-^-^");
        display.println("|                             |");
        display.println("|         1. Watchlist        |");
        display.println("|         2. Rankings         |");
        display.println("|         3. Exit             |");
        display.println("|                             |");
        display.println("|=============================|");

        display.close();
        Desktop.getDesktop().open(aniStat);
    }

    // WATCHLIST DISPLAY
    public void displayWL() throws FileNotFoundException, IOException{
        File aniStat = new File(".txt/Anistat.txt");
        
        File data = new File(".txt/MyData.txt");
        Scanner read = new Scanner(data);

        PrintWriter display = new PrintWriter(aniStat);
        String indent = " ".repeat(40);

        display.printf("%-40s %s %n", "-----------------", "===============================================================");
        display.printf("%-40s %s %n", "1. Edit Watchlist", "-------------------------- WatchList --------------------------");
        display.printf("%-40s %-31s %31s %n", "2. Filter / Sort ", "[Anime]", "[Status]");
        display.printf("%-40s %s %n", "3.     Back      ", "---------------------------------------------------------------");
        display.printf("%-40s %s %n", "-----------------", "===============================================================");

     
        while(read.hasNextLine()){
            String line = read.nextLine();
            int split = line.indexOf('|');

            String anime = line.substring(0, split - 1);
            String status = line.substring(split + 2);
            display.printf("%s %-31s %31s %n", indent, anime, status);
            display.println(indent + " ***************************************************************");
        }
        


        read.close();
        display.close();
        Desktop.getDesktop().open(aniStat);
    }


}