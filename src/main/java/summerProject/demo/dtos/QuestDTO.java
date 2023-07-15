package summerProject.demo.dtos;

public class QuestDTO {
    private String name;
    private String content;
    private GameLocationDTO questPlace;
    private GameLocationDTO returnPlace;
    private String reward;

    public QuestDTO() {
    }

    public QuestDTO(String name, String content, GameLocationDTO questPlace, GameLocationDTO returnPlace, String reward) {
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

    public GameLocationDTO getQuestPlace() {
        return questPlace;
    }

    public void setQuestPlace(GameLocationDTO questPlace) {
        this.questPlace = questPlace;
    }

    public GameLocationDTO getReturnPlace() {
        return returnPlace;
    }

    public void setReturnPlace(GameLocationDTO returnPlace) {
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
        return "QuestDTO{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", questPlace=" + questPlace +
                ", returnPlace=" + returnPlace +
                ", reward='" + reward + '\'' +
                '}';
    }
}
