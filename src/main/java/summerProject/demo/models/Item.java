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

    @OneToMany(mappedBy = "item")
    private List<RewardLog> rewardLogs = new ArrayList<>();

//    @OneToMany(mappedBy = "item")
    @OneToMany(mappedBy = "item")
    private List<InventoryLog> inventoryLogs = new ArrayList<>();
}
