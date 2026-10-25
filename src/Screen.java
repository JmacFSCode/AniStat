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
    public void displayWL(ArrayList<Anime> dataList) throws FileNotFoundException, IOException{
        File aniStat = new File(".txt/Anistat.txt");
            
        PrintWriter display = new PrintWriter(aniStat);
        String indent = " ".repeat(40);

        display.printf("%-40s %s %n", "-----------------", "===============================================================");
        display.printf("%-40s %s %n", "1. Edit Watchlist", "-------------------------- WatchList --------------------------");
        display.printf("%-40s %-31s %31s %n", "2. Filter / Sort ", "[Anime]", "[Status]");
        display.printf("%-40s %s %n", "3.     Back      ", "---------------------------------------------------------------");
        display.printf("%-40s %s %n", "-----------------", "===============================================================");

     
        for(Anime anime : dataList){

            display.printf("%s %-31s %31s %n", indent, anime.getTitle(), anime.getWatchStatus());
            display.println(indent + " ***************************************************************");
        }
        
        display.close();
        Desktop.getDesktop().open(aniStat);
    }

    // RATINGS DISPLAY
    public void displayRatings(ArrayList<Anime> dataList) throws FileNotFoundException, IOException{
        File aniStat = new File(".txt/Anistat.txt");
        
        PrintWriter display = new PrintWriter(aniStat);
        
        display.println("=================================================================================");
        display.println("* * * * * * * * * * * * * * * * * *RATINGS* * * * * * * * * * * * * * * * * * * *");
        display.println("=================================================================================");


        int rank = 1;
        for(Anime anime : dataList){

            if(anime.getRating() == -1.0){
                display.printf("%-40s%41s%n", anime.getTitle(), "UNRANKED");
                continue;
            }

            if(rank <= 10){
                display.println("#" + rank + " " + anime.getTitle() + 
                "\nRATING: " + anime.getRating() + " / 10.0" + 
                "\nDESCRIPTION: " + anime.getDescription());
                display.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

            }
            else{     
                display.printf("%-40s%41s%n", "#" + rank + " " + anime.getTitle(), anime.getRating() + " / 10.0" );
            }
            
            rank++;

        }

        display.close();
        Desktop.getDesktop().open(aniStat);

    }


}