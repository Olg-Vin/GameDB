package summerProject.demo.models;

import jakarta.persistence.*;
import summerProject.demo.models.compositeKeys.InventoryLogKeys;

@Entity
@Table(name = "inventory_log")
public class InventoryLog {
    @EmbeddedId
    InventoryLogKeys id;

    @ManyToOne
    @MapsId("characterName")
    @JoinColumn(name = "character_name")
    private Character character;
    @ManyToOne
    @MapsId("itemName")
    @JoinColumn(name = "item_name")
    private Item item;
    @Column(name = "count_of_item")
    private int count;

    protected InventoryLog() {
    }

    public InventoryLog(Character character, Item item, int count) {
        this.character = character;
        this.item = item;
        this.count = count;
    }

    public Character getCharacter() {
        return character;
    }

    protected void setCharacter(Character character) {
        this.character = character;
    }

    public Item getItem() {
        return item;
    }

    protected void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    protected void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "InventoryLog{" +
                "character=" + character +
                ", item=" + item +
                '}';
    }
}
