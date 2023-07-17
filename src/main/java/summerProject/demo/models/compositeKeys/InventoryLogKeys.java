package summerProject.demo.models.compositeKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InventoryLogKeys implements Serializable {
    @Column(name = "character_name")
    String characterName;
    @Column(name = "item_name")
    String itemName;

    public InventoryLogKeys() {
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryLogKeys that = (InventoryLogKeys) o;
        return Objects.equals(characterName, that.characterName) && Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterName, itemName);
    }

    @Override
    public String toString() {
        return "InventoryLogKeys{" +
                "characterName='" + characterName + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
