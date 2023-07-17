package summerProject.demo.models;

import jakarta.persistence.*;
import summerProject.demo.models.compositeKeys.RewardLogKeys;

@Entity
@Table(name = "reward_log")
public class RewardLog {
    @EmbeddedId
    RewardLogKeys id;

    @ManyToOne
    @MapsId("questName")
    @JoinColumn(name = "quest_name")
    private Quest quest;
    @ManyToOne
    @MapsId("itemName")
    @JoinColumn(name = "item_name")
    private Item item;
    @Column(name = "count_of_item")
    private int count;

    protected RewardLog() {
    }

    public RewardLog(Quest quest, Item item, int count) {
        this.quest = quest;
        this.item = item;
        this.count = count;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "RewardLog{" +
                "id=" + id +
                ", quest=" + quest +
                ", item=" + item +
                ", count=" + count +
                '}';
    }
}
