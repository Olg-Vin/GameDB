package summerProject.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character")
public class Character {
    @Id
    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;
    @Column(name = "character_class")
    private Integer characterClass;
    @Column(name = "level", nullable = false)
    private Integer level;
    @ManyToOne
    @JoinColumn
    private GameLocation currentLocation;
    @Column(name = "power_rate", nullable = false)
    private Integer powerRate;

    @ManyToMany
    @JoinTable(name = "quest_log",
            joinColumns = @JoinColumn(name = "character_name"),
            inverseJoinColumns = @JoinColumn(name = "quest_name"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"character_name", "quest_name"}))
    private List<Quest> quests = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "inventory_log",
            joinColumns = @JoinColumn(name = "character_name"),
            inverseJoinColumns = @JoinColumn(name = "item_name"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"character_name", "item_name"}))
    private List<Item> items = new ArrayList<>();

//    todo


}
