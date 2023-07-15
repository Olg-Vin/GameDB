package summerProject.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "quest_log")
public class QuestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Character character;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Quest quest;

    public QuestLog() {
    }

    public QuestLog(Character character, Quest quest) {
        this.character = character;
        this.quest = quest;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "QuestLog{" +
                "character=" + character +
                ", quest=" + quest +
                '}';
    }
}
