import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

public class WatchList{

    // Instance Variables
    private File data;
    private ArrayList<Anime> wL = new ArrayList<>();
    

    // Defaults to MyData.txt
    public WatchList() throws FileNotFoundException{
        data = new File(".txt/MyData.txt");
        loadWatchList();
    }
    // User can set the file name
    public WatchList(File data_) throws FileNotFoundException{
        data = data_;
        loadWatchList();
    }

    // Loads watchlist data into the <Anime> ArrayList
    public void loadWatchList() throws FileNotFoundException{

        wL.clear();

        Scanner read = new Scanner(data);

        while(read.hasNextLine()){
            String line = read.nextLine();
            String[] parts = line.split(" \\| ", -1);

            if (parts.length != 2 && parts.length != 4) {
                System.out.println("Invalid entry: " + line);
                continue;
            }

            String title = parts[0].trim();
            String status = parts[1].trim();

            if (parts.length == 2) {
                wL.add(new Anime(title, status));
            }
            else {
                try {
                    double rating = Double.parseDouble(parts[2].trim());
                    String description = parts[3].trim();

                    wL.add(new Anime(title, status, rating, description));

                } catch (NumberFormatException e) {
                    System.out.println("Invalid rating: " + line);
                }
            }
        }
        read.close();
     }

    

    // Updates the Watchlist data file
    public void updateWatchList() throws FileNotFoundException{
        PrintWriter update = new PrintWriter(data);


        for(Anime anime : wL){
            update.println(anime.getTitle() + " | " + anime.getWatchStatus() + " | " + anime.getRating() + " | " + anime.getDescription());
        }

        update.close();
    }

    // Adds Anime to WatchList
    public void addAnime(String name, String status) throws FileNotFoundException{
        
        Anime anime = new Anime(name, status);
        wL.add(anime);
        System.out.println("Anime Added Successfully!\n");

        updateWatchList();
        
    }

    // Removes Anime From WatchList
    public void remAnime(String name) throws FileNotFoundException{
        
        boolean remove = wL.removeIf(anime -> anime.getTitle().equalsIgnoreCase(name.trim()));

        if(remove){
            System.out.println("Anime Removed Successfully!\n");
            updateWatchList();
        }
        else{
            System.out.println("Anime Not Found In Watchlist.\n");
        }
        

    }

    // Edit an Anime's Watch Status
    public void editStatus(String name, String newStatus) throws FileNotFoundException{
        boolean found = false;

        for (Anime anime : wL){

            if (anime.getTitle().equalsIgnoreCase(name)){

                anime.setWatchStatus(newStatus);

                found = true;
                break;
            }
        }

        if (found == true) {
            updateWatchList();
            System.out.println("Status Updated Successfully!\n");
        }
        else {
            System.out.println("Anime Not Found In Watchlist.\n");
        }

    }

    // Filters the entered watchlist
    public ArrayList<Anime> filterWLTo(ArrayList<Anime> list, int option){

        ArrayList<Anime> filteredWL = new ArrayList<>(list);

        // Filter only Completed
        if(option == 1){         
            filteredWL.removeIf(anime -> !anime.getWatchStatus().equals("COMPLETED"));
        }
        // Filter Only Watching
        else if(option == 2){
             filteredWL.removeIf(anime -> !anime.getWatchStatus().equals("WATCHING"));
        }
        // Filter Only Planning
        else if(option == 3){
             filteredWL.removeIf(anime -> !anime.getWatchStatus().equals("PLAN TO WATCH"));
        }
        else if(option == 4){
             // Brings back watchList with all statuses; Default
        }
        
        return filteredWL;

    }

    // Sorts the entered WatchList
    public ArrayList<Anime> sortWLBy(ArrayList<Anime> list ,int option){

        ArrayList<Anime> sortedWL = new ArrayList<>(list);

        // Sorts Alphabetically
        if(option == 1){
            sortedWL.sort((a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()));
        }
        // Sorts by Newest First
        else if(option == 2){
            Collections.reverse(sortedWL);
        }
        // Sorts by Oldest First
        else if(option == 3){
            // Simply return the watchlist
        }

        return sortedWL;
    }


    // Returns a list that has been filtered & sorted appropriately
    public ArrayList<Anime> organizeWatchList(int sortOption, int filterOption) {

        ArrayList<Anime> filtered = filterWLTo(wL, filterOption);

        ArrayList<Anime> sorted = sortWLBy(filtered, sortOption);

        return sorted;
    }


    
    
}
