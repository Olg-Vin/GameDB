package summerProject.demo.models.compositeKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuestLogKeys implements Serializable {
    @Column(name = "character_name")
    String characterName;

    @Column(name = "quest_name")
    String questName;

    public QuestLogKeys() {
    }

    public QuestLogKeys(String characterName, String questName) {
        this.characterName = characterName;
        this.questName = questName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestLogKeys that = (QuestLogKeys) o;
        return Objects.equals(characterName, that.characterName) && Objects.equals(questName, that.questName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterName, questName);
    }

    @Override
    public String toString() {
        return "QuestLogKeys{" +
                "characterName='" + characterName + '\'' +
                ", questName='" + questName + '\'' +
                '}';
    }
}
