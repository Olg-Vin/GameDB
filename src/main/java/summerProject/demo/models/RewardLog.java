package summerProject.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "reward_log")
public class RewardLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Quest quest;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Item item;

    public RewardLog() {
    }

    public RewardLog(Quest quest, Item item) {
        this.quest = quest;
        this.item = item;
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

    @Override
    public String toString() {
        return "RewardLog{" +
                "quest=" + quest +
                ", item=" + item +
                '}';
    }
}
