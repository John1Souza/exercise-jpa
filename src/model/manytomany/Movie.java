package model.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private Double grade;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "actors_movies", joinColumns = @joinColumn(name = "movie_id", referencedColumnName = "id"),
        inverseJoinColumns = @joinColumn(name = "actor_id", referencedColumnName = "id")
    )
    private List<Actor> actors;
    
    public Movie(){

    }

    public Movie(String name, Double grade){
        super();
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(Double grade){
        this.grade = grade;
    } 

    public Double getGrade(){
        return name;
    }

    public void setGrade(Double grade){
        this.grade = grade;
    } 

    public List<Actor> getActors(){
        if(actors == null){
            actors = new ArrayList<>();
        }
        return actors;
    }
    public void setActors(List<Actor> actors){
        this.actors = actors;
    }

    public void addActor(Actor actor){
        if(actor != null && !getActors().contains(actor)){
            getActors().add(actor);
            if(!actor.getMovies().contains(this)){
                actor.getMovies().add(this);
            }
        }
    }
}