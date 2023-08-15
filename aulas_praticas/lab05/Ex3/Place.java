package Ex3;

public class Place {

    private String place_name;

    public Place(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    @Override
    public String toString() {
        return place_name;
    }

    
}
