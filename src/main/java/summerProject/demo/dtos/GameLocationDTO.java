package summerProject.demo.dtos;

public class GameLocationDTO {
    private String name;
    private String legend;
    private Integer maxNPC;

    public GameLocationDTO() {
    }

    public GameLocationDTO(String name, String legend, Integer maxNPC) {
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

    @Override
    public String toString() {
        return "GameLocationDTO{" +
                "name='" + name + '\'' +
                ", legend='" + legend + '\'' +
                ", maxNPC=" + maxNPC +
                '}';
    }
}
