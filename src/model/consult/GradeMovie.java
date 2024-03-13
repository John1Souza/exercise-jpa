package test.manytomany;

public class GradeMovies {
    
    private double mean;

    public GradeMovie(double mean){
        super();
        this.mean = mean;
    }

    public double getMean(){
        return mean;
    }

    public void setMean(double mean){
        this.mean = mean;
    }
}