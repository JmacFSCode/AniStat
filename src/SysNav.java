import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class SysNav{

    private int sortOption = 2;   // Default Watchlist Sorting: Newest First
    private int filterOption = 4; // Default Watchlist Filter: All statuses

    public SysNav(){}

    Screen screen = new Screen();
    Scanner in = new Scanner(System.in);


    // NAVIGATION METHODS
    // ******************

    // menu nav method
    public String navFrmMenu() throws IOException{
        
        screen.displayMenu();

        System.out.print("\nWhere Do You Want To Go? (Enter a number 1 - 3): ");
        int choice = getValidInt(1, 3);

        if(choice == 1){
            navFrmWL();
        }
        else if(choice == 2){
            System.out.println("RANKINGS (WIP)");
        }
        else if(choice == 3){
            return "CLOSE";
        }
        
        return "";
    }


    // watchlist nav method
    public void navFrmWL() throws IOException{
        
        WatchList watchlist = new WatchList();

        int choice = 0;
        
        while(choice != 3){
            
            ArrayList<String> result = watchlist.organizeWatchList(sortOption, filterOption);
            screen.displayWL(result);

            // edit watchlist, filter/sort, go back
            System.out.print("\nWhat Do You Want To Do? (Enter a number 1 - 3): ");
            choice = getValidInt(1, 3);
            
            int choice2;

            // edit watchlist
            if(choice == 1){
                System.out.println("Add? (1)\nRemove? (2)\nEdit Status? (3)");
                System.out.print("Enter a number 1 - 3: ");
                choice2 = getValidInt(1, 3);

                String name;
                String status;
                
                if(choice2 == 1){
                    System.out.print("Enter Anime Name: ");
                    name = in.nextLine();
                    System.out.print("Enter Anime Watch Status (COMPLETED, WATCHING, OR PLAN TO WATCH): ");
                    status = in.nextLine().trim().toUpperCase();

                    while(!status.equals("COMPLETED") && !status.equals("WATCHING") && !status.equals("PLAN TO WATCH")){
                        System.out.print("Not a Valid Watch Status. Try Again: ");
                        status = in.nextLine().trim().toUpperCase();
                    }
                    
                    watchlist.addAnime(name, status);
                }
                else if(choice2 == 2){
                    System.out.print("What Anime to Remove?: ");
                    name = in.nextLine();
                    
                    watchlist.remAnime(name);
                }
                else if(choice2 == 3){
                    System.out.print("Edit What Anime Status?: ");
                    name = in.nextLine();
                    System.out.print("Set Status To? (COMPLETED, WATCHING, OR PLAN TO WATCH): ");
                    status = in.nextLine().trim().toUpperCase();

                    while(!status.equals("COMPLETED") && !status.equals("WATCHING") && !status.equals("PLAN TO WATCH")){
                        System.out.print("Not a Valid Watch Status. Try Again: ");
                        status = in.nextLine().trim().toUpperCase();
                    }

                    watchlist.editStatus(name, status);
                }
                

            }
            // sort or filter watchlist
            else if(choice == 2){
                System.out.println("Sort(1) or Filter(2)?");
                System.out.print("Enter a number 1 - 2: ");
                choice2 = getValidInt(1, 2);
                
                if(choice2 == 1){
                    System.out.println("Sort By:\nAlphabet? (1)\nNewest Add. First? (2)\nOldest Add. First? (3)");
                    System.out.print("Enter a number 1 - 3: ");
                    int choice3 = getValidInt(1, 3);
                    
                    sortOption = choice3;
                }
                else if(choice2 == 2){
                    System.out.println("Filter:\nCompleted? (1)\nWatching? (2)\nPlan to Watch? (3)\nAll Statuses (4)");
                    System.out.print("Enter a number 1 - 4: ");
                    int choice3 = getValidInt(1, 4);

                    filterOption = choice3;
                }
            }
            // go back
            else if(choice == 3){
                return;
            }
        }

    }

    // Ratings Nav method
    // public void navFrmRankings() throws IOException{
    // }


    // SUPPLEMENTARY LOCAL METHODS
    // *********************

    private int getValidInt(int min, int max) {

        while (true) {
            String input = in.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);

                if (choice >= min && choice <= max) {
                    return choice;
                }

                System.out.print("Invalid Option. Enter " +
                                min + " - " + max + ": ");

            } catch (NumberFormatException e) {
                System.out.print("Invalid Input. Enter a number: ");
            }
        }
    }


    
}
