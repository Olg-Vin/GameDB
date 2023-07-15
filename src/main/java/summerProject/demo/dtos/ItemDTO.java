package summerProject.demo.dtos;

public class ItemDTO {
    private String name;
    private CharacteristicDTO properties;
    private Integer type;
    private String description;

    public ItemDTO() {
    }

    public ItemDTO(String name, CharacteristicDTO properties, Integer type, String description) {
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

    public CharacteristicDTO getProperties() {
        return properties;
    }

    public void setProperties(CharacteristicDTO properties) {
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
        return "ItemDTO{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                ", type=" + type +
                ", description='" + description + '\'' +
                '}';
    }
}
