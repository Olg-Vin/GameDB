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

    protected InventoryLog() {
    }

    public InventoryLog(Character character, Item item) {
        this.character = character;
        this.item = item;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "InventoryLog{" +
                "character=" + character +
                ", item=" + item +
                '}';
    }
}
