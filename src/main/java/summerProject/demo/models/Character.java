package summerProject.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "character")
public class Character {
    @Id
    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;
    @Column(name = "character_class")
    private int characterClass;
    @Column(name = "level", nullable = false)
    private int level;
    @ManyToOne
    @JoinColumn
    private GameLocation currentLocation;
    @OneToOne
    @JoinColumn
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Characteristic powerRate;

    protected Character() {
    }

    public Character(String name, int characterClass, int level,
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

    public int getCharacterClass() {
        return characterClass;
    }

    private void setCharacterClass(int characterClass) {
        this.characterClass = characterClass;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
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
