package summerProject.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "inventory_log")
public class InventoryLog {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Character character;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Item item;
}
