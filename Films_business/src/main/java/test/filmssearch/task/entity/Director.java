package test.filmssearch.task.entity;

import lombok.*;

import java.sql.Date;

@Data
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;

    public Director(Long id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }
}
