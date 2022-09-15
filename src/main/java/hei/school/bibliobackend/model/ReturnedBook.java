package hei.school.bibliobackend.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "returnedBook")
@EqualsAndHashCode
public class ReturnedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column
    private String title;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String date;
}
