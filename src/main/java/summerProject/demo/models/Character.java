package summerProject.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "character")
public class Character {
    @Id
    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;
    @Column(name = "character_class")
    private Integer characterClass;
    @Column(name = "level", nullable = false)
    private Integer level;
    @ManyToOne
    @JoinColumn
    private GameLocation currentLocation;
    @Column(name = "power_rate", nullable = false)
    private Integer powerRate;

    @OneToMany(mappedBy = "character")
    private List<QuestLog> questLogs = new ArrayList<>();

    @OneToMany(mappedBy = "character")
    private List<InventoryLog> items = new ArrayList<>();

//    todo add methods for lists


    public Character() {
    }

    public Character(String name, Integer characterClass, Integer level,
                     GameLocation currentLocation, Integer powerRate) {
//                     List<Quest> quests, List<Item> items
        this.name = name;
        this.characterClass = characterClass;
        this.level = level;
        this.currentLocation = currentLocation;
        this.powerRate = powerRate;
//        this.quests = quests;
//        this.items = items;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getCharacterClass() {
        return characterClass;
    }

    private void setCharacterClass(Integer characterClass) {
        this.characterClass = characterClass;
    }

    public Integer getLevel() {
        return level;
    }

    private void setLevel(Integer level) {
        this.level = level;
    }

    public GameLocation getCurrentLocation() {
        return currentLocation;
    }

    private void setCurrentLocation(GameLocation currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Integer getPowerRate() {
        return powerRate;
    }

    private void setPowerRate(Integer powerRate) {
        this.powerRate = powerRate;
    }


    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", characterClass=" + characterClass +
                ", level=" + level +
                ", currentLocation=" + currentLocation +
                ", powerRate=" + powerRate +
//                ", quests=" + quests +
                ", items=" + items +
                '}';
    }
}
