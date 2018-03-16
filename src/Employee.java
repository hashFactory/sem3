public class Employee
{
    private String name = "NoName";
    private String hireDate = "1999";

    public Employee()
    {

    }

    public Employee(String name, String hireDate)
    {
        this.name = name;
        this.hireDate = hireDate;
    }

    public String getName()
    {
        return name;
    }

    public String getHireDate()
    {
        return hireDate;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setHireDate(String hireDate)
    {
        this.hireDate = hireDate;
    }

    public String toString()
    {
        return "Name: " + this.name + ", hireDate: " + this.hireDate;
    }

    public boolean equals()
    {
        return true;
    }
}
