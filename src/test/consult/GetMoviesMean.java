package test.manytomany;

import infra.DAO;
import model.manytomany.Movie;


public class GetMoviesMean {
    public static void main (String[] args){
       Infra.DAO<Movie> dao = new DAO<>(GradeMovie.class);
       GradeMovie grade = dao.consultOne("getGeneralMeanFromMovies");

       System.out.println(grade.getMean());

       dao.closeDAO();
    }
}