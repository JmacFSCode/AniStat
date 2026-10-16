public class Anime {
    private String title;
    private String status;
    private double rating;
    private String desc;

    public Anime(){
        title = "N/A";
        status = "N/A";
        rating = 0;
        desc = "N/A";
    }

    public Anime(String _title, String _status){
        title = _title;
        status = _status;
        rating = 0;
        desc = "N/A";
    }

    public Anime(String _title, String _status, double _rating, String _desc){
        title = _title;
        status = _status;
        rating = _rating;
        desc = _desc;
    }


     public String getTitle() {
        return title;
    }

    public String getWatchStatus() {
        return status;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return desc;
    }

    public void setWatchStatus(String status) {
        this.status = status;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.desc = description;
    }
}

