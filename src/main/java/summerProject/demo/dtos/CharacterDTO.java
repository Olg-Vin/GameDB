package summerProject.demo.dtos;

public class CharacterDTO {
    private String name;
    private int characterClass;
    private int level;
    private GameLocationDTO currentLocation;
    private CharacteristicDTO powerRate;

    public CharacterDTO() {
    }

    public CharacterDTO(String name, int characterClass) {
        this.name = name;
        this.characterClass = characterClass;
    }

    public CharacterDTO(String name, int characterClass, int level, GameLocationDTO currentLocation, CharacteristicDTO powerRate) {
        this.name = name;
        this.characterClass = characterClass;
        this.level = level;
        this.currentLocation = currentLocation;
        this.powerRate = powerRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    public void setLevel(int level) {
        this.level = level;
    }

    public GameLocationDTO getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(GameLocationDTO currentLocation) {
        this.currentLocation = currentLocation;
    }

    public CharacteristicDTO getPowerRate() {
        return powerRate;
    }

    public void setPowerRate(CharacteristicDTO powerRate) {
        this.powerRate = powerRate;
    }

    @Override
    public String toString() {
        return "CharacterDTO{" +
                "name='" + name + '\'' +
                ", characterClass=" + characterClass +
                ", level=" + level +
                ", currentLocation=" + currentLocation +
                ", powerRate=" + powerRate +
                '}';
    }
}
