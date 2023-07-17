package summerProject.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "name", length = 255, nullable = false, unique = true)
    private String name;
    @OneToOne
    @JoinColumn(name = "properties")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Characteristic properties;
    @Column(name = "type", nullable = false)
    private Integer type;
    @Column(name = "description", length = 255, nullable = false)
    private String description;

    protected Item() {
    }

    public Item(String name, Characteristic properties, Integer type, String description) {
        this.name = name;
        this.properties = properties;
        this.type = type;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Characteristic getProperties() {
        return properties;
    }

    public void setProperties(Characteristic properties) {
        this.properties = properties;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }
}
