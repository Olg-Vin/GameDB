package summerProject.demo.dtos;

public class CharacterDTO {
    private String name;
    private Integer characterClass;
    private Integer level;
    private GameLocationDTO currentLocation;
    private Integer powerRate;

    public CharacterDTO() {
    }

    public CharacterDTO(String name, Integer characterClass, Integer level, GameLocationDTO currentLocation, Integer powerRate) {
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

    public GameLocationDTO getCurrentLocation() {
        return currentLocation;
    }

    private void setCurrentLocation(GameLocationDTO currentLocation) {
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
        return "CharacterDTO{" +
                "name='" + name + '\'' +
                ", characterClass=" + characterClass +
                ", level=" + level +
                ", currentLocation=" + currentLocation +
                ", powerRate=" + powerRate +
                '}';
    }
}
