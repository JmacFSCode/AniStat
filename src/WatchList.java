import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

public class WatchList{

    // Instance Variables
    private File data;
    private ArrayList<String> wL = new ArrayList<>();
    

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

    // Loads watchlist data into an array list
    public void loadWatchList() throws FileNotFoundException{

        wL.clear();

        Scanner read = new Scanner(data);

        while(read.hasNextLine()){
            String line = read.nextLine();
            wL.add(line);
        }

        read.close();
    }

    // Updates the Watchlist data file
    public void updateWatchList() throws FileNotFoundException{
        PrintWriter update = new PrintWriter(data);

        for(int i = 0; i < wL.size(); i++){
            update.println(wL.get(i));
        }

        update.close();
    }

    // Adds Anime to WatchList
    public void addAnime(String name, String status) throws FileNotFoundException{
        String anime = name + " | " + status;
        wL.add(anime);
        System.out.println("Anime Added Successfully!\n");

        updateWatchList();
        
    }

    // Removes Anime From WatchList
    public void remAnime(String name) throws FileNotFoundException{
        boolean remove = wL.removeIf(anime -> {String title = anime.split("\\|", 2)[0].trim();
        return title.equalsIgnoreCase(name.trim()); 
        });

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

        for (int i = 0; i < wL.size(); i++) {

            String anime = wL.get(i);

            if (anime.startsWith(name + " | ")) {

                wL.set(i, name + " | " + newStatus);

                found = true;
                break;
            }
        }

        if (found) {
            updateWatchList();
            System.out.println("Status Updated Successfully!\n");
        }
        else {
            System.out.println("Anime Not Found In Watchlist.\n");
        }

    }

    // Filters the entered watchlist
    public ArrayList<String> filterWLTo(ArrayList<String> list, int option){

        ArrayList<String> filteredWL = new ArrayList<>(list);

        // Filter only Completed
        if(option == 1){         
            filteredWL.removeIf(anime -> !anime.contains("| COMPLETED"));
        }
        // Filter Only Watching
        else if(option == 2){
             filteredWL.removeIf(anime -> !anime.contains("| WATCHING"));
        }
        // Filter Only Planning
        else if(option == 3){
             filteredWL.removeIf(anime -> !anime.contains("| PLAN TO WATCH"));
        }
        else if(option == 4){
             // Brings back watchList with all statuses; Default
        }
        
        return filteredWL;

    }

    // Sorts the entered WatchList
    public ArrayList<String> sortWLBy(ArrayList<String> list ,int option){

        ArrayList<String> sortedWL = new ArrayList<>(list);

        // Sorts Alphabetically
        if(option == 1){
            Collections.sort(sortedWL);
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
    public ArrayList<String> organizeWatchList(int sortOption, int filterOption) {

        ArrayList<String> filtered = filterWLTo(wL, filterOption);

        ArrayList<String> sorted = sortWLBy(filtered, sortOption);

        return sorted;
    }


    


    

    
    
}
