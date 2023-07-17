package summerProject.demo.models;

import jakarta.persistence.*;
import summerProject.demo.models.compositeKeys.QuestLogKeys;

@Entity
@Table(name = "quest_log")
public class QuestLog {

    @EmbeddedId
    QuestLogKeys id;

    @ManyToOne
    @MapsId("characterName")
    @JoinColumn
    private Character character;
    @ManyToOne
    @MapsId("questName")
    @JoinColumn
    private Quest quest;

    public QuestLog() {
    }

    public QuestLog(QuestLogKeys key) {
        this.id = key;
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
