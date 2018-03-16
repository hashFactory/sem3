package WeekWhatever;

public class House extends Abode
{
    private double land = 0;
    private int driveways = 0;

    public House()
    {
        super();
        this.land = 0.5;
        this.driveways = 1;
    }

    public House(String walls, int bathrooms, int kitchens, double land, int driveways)
    {
        super();
        setWalls(walls);
        setBathrooms(bathrooms);
        setKitchens(kitchens);
        setLand(land);
        setDriveways(driveways);
    }

    public double getLand() {
        return land;
    }

    public void setLand(double land) {
        this.land = land;
    }

    public int getDriveways() {
        return driveways;
    }

    public void setDriveways(int driveways) {
        this.driveways = driveways;
    }

    @Override
    public String toString() {
        return "House{" +
                "land=" + land +
                ", driveways=" + driveways +
                "} " + super.toString();
    }


}
