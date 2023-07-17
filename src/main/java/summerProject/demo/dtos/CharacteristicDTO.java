package summerProject.demo.dtos;

public class CharacteristicDTO {
    private int id;
    private int strength;
    private int health;
    private int intelligence;
    private int dexterity;
    private int charisma;
    private int luck;

    public CharacteristicDTO() {
    }

    public CharacteristicDTO(int id, int strength, int health, int intelligence,
                             int dexterity, int charisma, int luck) {
        this.id = id;
        this.strength = strength;
        this.health = health;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.charisma = charisma;
        this.luck = luck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
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
