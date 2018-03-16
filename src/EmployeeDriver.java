public class EmployeeDriver
{
    public static void main(String [] args)
    {
        Employee[] employees = new Employee[5];
        for (int i = 0; i < 3; i++)
            employees[i] = new Employee();
        employees[3] = new Employee("Tommy", "2013");
        employees[4] = new Employee("Dean", "2012");

        for (Employee employee: employees)
            System.out.println(employee.toString());
    }
}
