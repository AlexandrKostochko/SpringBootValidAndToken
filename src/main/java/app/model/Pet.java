package app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
    public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;

    @Pattern(regexp = "[A-Z][a-z]{2,7}")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    private PetStatus petStatus;
}
