package summerProject.demo.models;

import jakarta.persistence.*;

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
//            (fetch = FetchType.LAZY)
    @JoinColumn
    private GameLocation currentLocation;
    @OneToOne
    @JoinColumn
    private Characteristic powerRate;

    protected Character() {
    }

    public Character(String name, Integer characterClass, Integer level,
                     GameLocation currentLocation, Characteristic powerRate) {
        this.name = name;
        this.characterClass = characterClass;
        this.level = level;
        this.currentLocation = currentLocation;
        this.powerRate = powerRate;
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

    public Characteristic getPowerRate() {
        return powerRate;
    }

    private void setPowerRate(Characteristic powerRate) {
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
                '}';
    }
}
