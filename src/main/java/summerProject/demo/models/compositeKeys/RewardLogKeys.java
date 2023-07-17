package summerProject.demo.models.compositeKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RewardLogKeys implements Serializable {
    @Column(name = "quest_name")
    String questName;

    @Column(name = "item_name")
    String itemName;

    public RewardLogKeys() {
    }

    public RewardLogKeys(String questName, String itemName) {
        this.questName = questName;
        this.itemName = itemName;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
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
        RewardLogKeys that = (RewardLogKeys) o;
        return Objects.equals(questName, that.questName) && Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questName, itemName);
    }

    @Override
    public String toString() {
        return "RewardLogKeys{" +
                "questName='" + questName + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
