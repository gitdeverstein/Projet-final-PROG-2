package hei.school.bibliobackend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "category")
@EqualsAndHashCode
public class Category {
    @Id
    @Column
    private Integer id;

    @Column
    private String name;
}
