package summerProject.demo.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characteristic")
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    todo not null attribute
    private Integer id;
    @Column(name = "strength")
    private Integer strength;
    @Column(name = "health")
    private Integer health;
    @Column(name = "intelligence")
    private Integer intelligence;
    @Column(name = "dexterity")
    private Integer dexterity;
    @Column(name = "charisma")
    private Integer charisma;
    @Column(name = "luck")
    private Integer luck;

    @OneToOne(mappedBy = "properties")
    private Item item;

}
