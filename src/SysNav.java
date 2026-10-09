import java.util.Scanner;
import java.io.IOException;

public class SysNav{

    public SysNav(){}


    Screen screen = new Screen();
    Scanner in = new Scanner(System.in);

    // menu nav method
    public String navFrmMenu() throws IOException{
        
        screen.displayMenu();

        System.out.print("\nWhere Do You Want To Go? (Enter 1, 2, or 3): ");
        int choice = in.nextInt();

        while(choice != 1 && choice != 2 && choice != 3){
            System.out.print("Invalid Option. Select 1, 2, or 3: ");
            choice = in.nextInt();
        }

        
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

        int choice = 0;
        
        while(choice != 3){
            screen.displayWL();

            // edit watchlist, filter/sort, go back
            System.out.print("\nWhat Do You Want To Do? (Enter 1, 2, or 3): ");
            choice = in.nextInt();
            
            while(choice != 1 && choice != 2 && choice != 3){
                System.out.print("Invalid Option. Select 1, 2, or 3: ");
                choice = in.nextInt();
            }
            
            int choice2;

            // **edit watchlist
            if(choice == 1){
                System.out.println("Add? (1)\nRemove? (2)\nEdit Status? (3)");
                System.out.print("Enter a number 1 - 3: ");
                choice2 = in.nextInt();

                while(choice2 != 1 && choice2 != 2 && choice2 != 3){
                    System.out.print("Invalid Option. Select 1, 2, or 3: ");
                    choice2 = in.nextInt();
                }

                String name;
                String status;
                
                in.nextLine();
                
                if(choice2 == 1){
                    System.out.print("Enter Anime Name: ");
                    name = in.nextLine();
                    System.out.print("Enter Anime Watch Status: ");
                    status = in.nextLine();
                    // watchlist.add(name, status)
                }
                else if(choice2 == 2){
                    System.out.print("What Anime to Remove?: ");
                    name = in.nextLine();
                    // watchlist.remove(name)

                }
                else if(choice2 == 3){
                    System.out.print("Edit What Anime Status?: ");
                    name = in.nextLine();
                    System.out.print("Set Status To?: ");
                    status = in.nextLine();
                    // watchlist.setStatus(name, status)
                }
                

            }
            // sort or filter watchlist
            else if(choice == 2){
                System.out.print("Sort(1) or Filter(2)?:");
                System.out.print("Enter a number 1 - 2: ");
                choice2 = in.nextInt();

                while(choice2 != 1 && choice2 != 2){
                    System.out.print("Invalid Option. Select 1 or 2: ");
                    choice2 = in.nextInt();
                }
                
                if(choice2 == 1){
                    System.out.println("Sort By:\nAlphabet? (1)\nRecency, Descending? (2)\nRecency, Ascending? (3)");
                    System.out.print("Enter a number 1 - 3: ");
                    int choice3 = in.nextInt();

                    while(choice3 != 1 && choice3 != 2 && choice3 != 3){
                        System.out.print("Invalid Option. Select 1, 2 or 3: ");
                        choice3 = in.nextInt();
                    }
                    //watchlist.sortBy(choice3)

                }
                else if(choice2 == 2){
                    System.out.println("Filter:\nCompleted? (1)\nWatching? (2)\nPlan to Watch? (3)");
                    System.out.print("Enter a number 1 - 3: ");
                    int choice3 = in.nextInt();
                    
                    while(choice3 != 1 && choice3 != 2 && choice3 != 3){
                        System.out.print("Invalid Option. Select 1, 2 or 3: ");
                        choice3 = in.nextInt();
                    }
                    //watchlist.filter(choice3)
                }
            }
            // go back
            else if(choice == 3){
                return;
            }
        }

    }

    // Rankings Nav method
    public void navFrmRankings() throws IOException{

    }


    
}
