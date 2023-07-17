package summerProject.demo.dtos;

public class GameLocationDTO {
    private String name;
    private String legend;
    private int maxNPC;

    public GameLocationDTO() {
    }

    public GameLocationDTO(String name, String legend, int maxNPC) {
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
        return "GameLocationDTO{" +
                "name='" + name + '\'' +
                ", legend='" + legend + '\'' +
                ", maxNPC=" + maxNPC +
                '}';
    }
}
