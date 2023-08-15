package Ex3;

import java.util.*;

public class Ex3 {
    
    public static void main(String[] args) {

        Movie FF =new Movie.Builder("Fast and Furious: Tokio Drift", 2006)
        .director(new Person("Justin Linn"))
        .writer(new Person("Chris Morgan"))
        .series("Fast and Furious")
        .cast(List.of(new Person("Vin Diesel"), new Person("Lucas Black"),new Person("Sung Kang"),new Person("Nathalie Kelley")))
        .locations(List.of(new Place("Tokio"), new Place("Los Angeles")))
        .languages(List.of("English"))
        .genres(List.of("Action"))
        .isTelevision(true)
        .isNetflix(false)
        .isIndependent(true)
        .build();

        System.out.println(FF);
    
    }
}
