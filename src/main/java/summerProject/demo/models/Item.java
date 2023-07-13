package summerProject.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;

    @OneToOne
    @JoinColumn
    private Characteristic properties;

    @Column(name = "type", nullable = false)
    private Integer type;
    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(name = "reward_log",
            joinColumns = @JoinColumn(name = "item_name"),
            inverseJoinColumns = @JoinColumn(name = "quest_name"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"item_name", "quest_name"}))
    private List<Quest> quests = new ArrayList<>();

    @ManyToMany(mappedBy = "items")
    private List<Character> characters = new ArrayList<>();
}
