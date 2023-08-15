package Ex3;

public class Person {

    private String person_name;

    public Person(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    @Override
    public String toString() {
        return person_name;
    }
    
}
