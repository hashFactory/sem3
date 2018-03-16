public class HourlyEmployee extends Employee
{
    private double wage = 0;
    private int hours = 0;

    public HourlyEmployee()
    {
        super();
        this.wage = 7.25;
        this.hours = 10;
    }

    public HourlyEmployee(String name, String hireDate, double wage, int hours)
    {
        super(name, hireDate);
        this.wage = wage;
        this.hours = hours;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "wage=" + wage +
                ", hours=" + hours +
                '}';
    }
}
