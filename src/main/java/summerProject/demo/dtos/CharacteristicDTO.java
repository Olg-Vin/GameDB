package summerProject.demo.dtos;

public class CharacteristicDTO {
    private Integer id = 0;
    private Integer strength = 50;
    private Integer health = 150;
    private Integer intelligence = 50;
    private Integer dexterity = 50;
    private Integer charisma = 50;
    private Integer luck = 50;

    public CharacteristicDTO() {
    }

    public CharacteristicDTO(Integer id, Integer strength, Integer health, Integer intelligence,
                             Integer dexterity, Integer charisma, Integer luck) {
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
        return "CharacteristicDTO{" +
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
