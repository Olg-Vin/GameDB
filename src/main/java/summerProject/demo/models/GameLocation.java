package summerProject.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "location")
public class GameLocation {
    @Id
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "legend", length = 512)
    private String legend;
    @Column(name = "max_npc")
    private int maxNPC;

    protected GameLocation() {
    }

    public GameLocation(String name, String legend, int maxNPC) {
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

    public int getMaxNPC() {
        return maxNPC;
    }

    public void setMaxNPC(int maxNPC) {
        this.maxNPC = maxNPC;
    }

    @Override
    public String toString() {
        return "GameLocation{" +
                "name='" + name + '\'' +
                ", legend='" + legend + '\'' +
                ", maxNPC=" + maxNPC +
                '}';
    }
}
