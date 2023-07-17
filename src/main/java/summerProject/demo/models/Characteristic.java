package summerProject.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "characteristic")
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    todo not null attribute
    private Integer id;
    @Column(name = "strength")
    private Integer strength;
    @Column(name = "health")
    private Integer health;
    @Column(name = "intelligence")
    private Integer intelligence;
    @Column(name = "dexterity")
    private Integer dexterity;
    @Column(name = "charisma")
    private Integer charisma;
    @Column(name = "luck")
    private Integer luck;

    public Characteristic() {
    }

    public Characteristic(Integer id, Integer strength, Integer health, Integer intelligence, Integer dexterity, Integer charisma, Integer luck) {
        this.id = id;
        this.strength = strength;
        this.health = health;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.charisma = charisma;
        this.luck = luck;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Integer getLuck() {
        return luck;
    }

    public void setLuck(Integer luck) {
        this.luck = luck;
    }

    @Override
    public String toString() {
        return "Characteristic{" +
                "id=" + id +
                ", strength=" + strength +
                ", health=" + health +
                ", intelligence=" + intelligence +
                ", dexterity=" + dexterity +
                ", charisma=" + charisma +
                ", luck=" + luck +
                '}';
    }
}
