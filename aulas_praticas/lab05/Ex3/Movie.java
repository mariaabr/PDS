package Ex3;

import java.util.*;

public class Movie {

    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder {
        // parametros obrigatórios
        private final String title;
        private final int year;

        // parametros opcionais
        private Person director = null;
        private Person writer = null;
        private String series = null;
        private List<Person> cast = null;
        private List<Place> locations = null;
        private List<String> languages = null;
        private List<String> genres = null;
        private boolean isTelevision = false;
        private boolean isNetflix = false;
        private boolean isIndependent = false;

        public Builder(String title, int year) {
            this.title = title;
            this.year = year;
        }

        public Builder director(Person person) {
            director=person;
            return this;
        }
        public Builder writer(Person person) {
            writer=person;
            return this;
        }
        public Builder series(String string) {
            series=string;
            return this;
        }
        public Builder cast(List<Person> list) {
            cast=list;
            return this;
        }
        public Builder locations(List<Place> list) {
            locations=list;
            return this;
        }
        public Builder languages(List<String> list) {
            languages=list;
            return this;
        }
        public Builder genres(List<String> list) {
            genres=list;
            return this;
        }
        public Builder isTelevision(boolean bool) {
            isTelevision=bool;
            return this;
        }
        public Builder isNetflix(boolean bool) {
            isNetflix=bool;
            return this;
        }
        public Builder isIndependent(boolean bool) {
            isNetflix=bool;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

    private Movie(Builder MovieBuilder){

        title = MovieBuilder.title;
        year = MovieBuilder.year;
        director = MovieBuilder.director;
        writer = MovieBuilder.writer;
        series = MovieBuilder.series;
        cast = MovieBuilder.cast;
        locations = MovieBuilder.locations;
        languages = MovieBuilder.languages;
        genres = MovieBuilder.genres;
        isTelevision = MovieBuilder.isTelevision;
        isNetflix = MovieBuilder.isNetflix;
        isIndependent = MovieBuilder.isIndependent;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", year=" + year + ", director=" + director + ", writer=" + writer
                + ", series=" + series + ", cast=" + cast + ", locations=" + locations + ", languages=" + languages
                + ", genres=" + genres + ", isTelevision=" + isTelevision + ", isNetflix=" + isNetflix
                + ", isIndependent=" + isIndependent + "]";
    }

}
