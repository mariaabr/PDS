public class Contact {

    private String name;
    private String number;

    public Contact (String name, String number){

        this.name = name;
        this.number = number;
    }

    public String getName(){
        return this.name;
    }

    public String getNumber(){
        return this.number;
    }

    @Override
    public String toString() {
        return name + ": " + number;
    }
    
}