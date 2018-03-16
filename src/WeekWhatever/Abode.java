package WeekWhatever;

public class Abode
{

    private String walls = "";
    private int bathrooms = 0;
    private int kitchens = 0;

    public Abode()
    {
        this.walls = "white";
        this.bathrooms = 1;
        this.kitchens = 1;
    }

    public Abode(String walls, int bathrooms, int kitchens)
    {
        this.walls = walls;
        this.bathrooms = bathrooms;
        this.kitchens = kitchens;
    }

    public String getWalls() {
        return walls;
    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getKitchens() {
        return kitchens;
    }

    public void setKitchens(int kitchens) {
        this.kitchens = kitchens;
    }

    @Override
    public String toString() {
        return "Abode{" +
                "walls='" + walls + '\'' +
                ", bathrooms=" + bathrooms +
                ", kitchens=" + kitchens +
                '}';
    }
}
