package main;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String movieTitle;
    private String movieDirector;
    private String movieRanking;

    public static List<Movie> movies;

    public Movie(String movieTitle, String movieDirector, String movieRanking) {
        this.movieTitle = movieTitle;
        this.movieDirector = movieDirector;
        this.movieRanking = movieRanking;
    }

    public void initMovieList(){
        movies = new ArrayList<Movie>();
        movies.add(new Movie("Rocky", "John G. Avildsen", "10"));
        movies.add(new Movie("Rocky II", "John G. Avildsen", "9"));
        movies.add(new Movie("Rocky III", "John G. Avildsen", "8"));
        movies.add(new Movie("Rocky IV", "John G. Avildsen", "7"));
        movies.add(new Movie("Rocky V", "John G. Avildsen", "8"));
        movies.add(new Movie("Drainage", "Francisco Trindade", "N/A"));
        movies.add(new Movie("The Shawshank Redemption", "Frank Darabont", "10"));
        movies.add(new Movie("The Godfather", "Francis Ford Coppola", "7"));
        movies.add(new Movie("Inception", "Frank Darabont", "10"));
        movies.add(new Movie("Pulp Fiction", "Quentin Tarantino", "6"));
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieTitle='" + movieTitle + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieRanking='" + movieRanking + '\'' +
                '}';
    }

    public void movieListing(){
          for(Movie movie:movies){
              System.out.println(movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking);
          }
    }
}
