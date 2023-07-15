package summerProject.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "quest")
public class Quest {
    @Id
    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;
    @Column(name = "content", length = 512, nullable = false)
    private String content;
    @OneToOne
    @JoinColumn
    private GameLocation questPlace;
    @OneToOne
    @JoinColumn
    private GameLocation returnPlace;
    @Column(name = "reward", length = 255, nullable = false)
    private String reward;

    protected Quest() {
    }

    public Quest(String name, String content, GameLocation questPlace, GameLocation returnPlace, String reward) {
        this.name = name;
        this.content = content;
        this.questPlace = questPlace;
        this.returnPlace = returnPlace;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public GameLocation getQuestPlace() {
        return questPlace;
    }

    public void setQuestPlace(GameLocation questPlace) {
        this.questPlace = questPlace;
    }

    public GameLocation getReturnPlace() {
        return returnPlace;
    }

    public void setReturnPlace(GameLocation returnPlace) {
        this.returnPlace = returnPlace;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", questPlace=" + questPlace +
                ", returnPlace=" + returnPlace +
                ", reward='" + reward + '\'' +
                '}';
    }
}
