package summerProject.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class GameLocation {
    @Id
    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;
    @Column(name = "legend", length = 512)
    private String legend;
    @Column(name = "max_npc")
    private Integer maxNPC;

    @OneToMany(mappedBy = "currentLocation")
    private List<Character> characters = new ArrayList<>();

}
