//import java.io.File;
import java.io.FileNotFoundException;
//import java.util.Scanner;
import java.io.IOException;

public class AniStat {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        SysNav nav = new SysNav();
        String menOpt = "";
        
        // Start system and loop until user exits
        do{
            menOpt = nav.navFrmMenu();

        }while (!menOpt.equals("CLOSE")); 
            
        

    }
}