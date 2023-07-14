package summerProject.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
public class GameLocation {
    @Id
    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;
    @Column(name = "legend", length = 512)
    private String legend;
    @Column(name = "max_npc")
    private Integer maxNPC;

    @OneToMany(mappedBy = "currentLocation")
    private List<Character> characters = new ArrayList<>();

    public GameLocation() {
    }

    public GameLocation(String name, String legend, Integer maxNPC) {
        this.name = name;
        this.legend = legend;
        this.maxNPC = maxNPC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public Integer getMaxNPC() {
        return maxNPC;
    }

    public void setMaxNPC(Integer maxNPC) {
        this.maxNPC = maxNPC;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "GameLocation{" +
                "name='" + name + '\'' +
                ", legend='" + legend + '\'' +
                ", maxNPC=" + maxNPC +
                ", characters=" + characters +
                '}';
    }
}
