import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    public void displayWL(ArrayList<String> dataList) throws FileNotFoundException, IOException{
        File aniStat = new File(".txt/Anistat.txt");
        
        

        PrintWriter display = new PrintWriter(aniStat);
        String indent = " ".repeat(40);

        display.printf("%-40s %s %n", "-----------------", "===============================================================");
        display.printf("%-40s %s %n", "1. Edit Watchlist", "-------------------------- WatchList --------------------------");
        display.printf("%-40s %-31s %31s %n", "2. Filter / Sort ", "[Anime]", "[Status]");
        display.printf("%-40s %s %n", "3.     Back      ", "---------------------------------------------------------------");
        display.printf("%-40s %s %n", "-----------------", "===============================================================");

     
        for(int i = 0; i < dataList.size(); i++){
            String entry = dataList.get(i);
            String[] parts = entry.split("\\|", 2);

            if (parts.length != 2) {
                continue;
            }

            String anime = parts[0].trim();
            String status = parts[1].trim();
            display.printf("%s %-31s %31s %n", indent, anime, status);
            display.println(indent + " ***************************************************************");
        }
        
        display.close();
        Desktop.getDesktop().open(aniStat);
    }


}