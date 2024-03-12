package test.manytomany;

import model.manytomany.Movie;
import model.manytomany.Actor;

public class NewMovieActor {
    public static void main (String[] args){
        Movie movieA = new Movie("Star Wars Ep 4", 8.7);
        Movie movieB = new Movie("O Fugitivo", 8.9);

        Actor actorA = new Actor("Harrison Ford");
        Actor actorB = new Actor("Carrie Fisher");

        movieA.addActor(actorA);
        movieA.addActor(actorB);

        movieB.addActor(actorA);


        DAO<Movie> dao = new DAO<>();

        dao.addAtomicTransaction(movieA);
    }
}