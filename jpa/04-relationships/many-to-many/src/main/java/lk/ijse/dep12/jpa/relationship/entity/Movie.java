package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    private String id;
    private String name;
    private String genre;
    @Column(name = "release_year")
    private Date releaseYear;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
    private List<Actor> actors = new ArrayList<>();

    public Movie(String id, String name, String genre, Date releaseYear) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}
