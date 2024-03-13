package test.manytomany;

import java.utils.List;

import infra.DAO;
import model.manytomany.Movie;


public class GetMovies {
    public static void main (String[] args){
       DAO<Movie> dao = new DAO<>(Movie.class);
       List<Movie> movies = dao.consult("GetMovieGradeBiggerThan", "grade", 8.5);

       for(Movie movie: movies){
        System.out.println(movie.getName() + " => " + movie.getDrade());
        for(Actor actor: movie.getActors()){
            System.out.println(movie.getName());
        }
       }
    }
}