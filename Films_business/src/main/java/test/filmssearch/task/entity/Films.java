package test.filmssearch.task.entity;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Films {
    private Long id;
    private Director director;
    private Long director_id;
    private String name;
    private Long releaseDate;
    private String genre;

    public Films(Long id, Director director, String name, Long releaseDate, String genre) {
        this.id = id;
        this.director = director;
        this.releaseDate = releaseDate;
        this.name = name;
        this.genre = genre;
    }
    public void setDirector_id(Long director_id) {
        this.director_id = director.getId();
    }
}
