package SalaryCalculatorApp;
import java.util.Scanner;

interface payment
{
    int calulateSalary();
}

abstract class employee implements payment
{
    String name, surname;
    int insuranceno;
    
    public employee(String name, String surname, int insuranceno)
    {
        this.name = name;
        this.surname = surname;
        this.insuranceno = insuranceno;
    }
}

class SalariedEmployee extends employee
{
    int weeklywage;
    
    public SalariedEmployee(String name, String surname, int insuranceno, int weeklywage)
    {
        super(name, surname, insuranceno);
        this.weeklywage = weeklywage;
    }

    @Override
    public int calulateSalary() {
        return weeklywage*4;
    }
}

class HourlyEmployee extends employee
{
    int hourlywage, totalhours;
    
    public HourlyEmployee(String name, String surname, int insuranceno, int hourlywage, int totalhours)
    {
        super(name, surname, insuranceno);
        this.hourlywage = hourlywage;
        this.totalhours = totalhours;
    }

    @Override
    public int calulateSalary() {
        if(totalhours <= 40)
        {
            return hourlywage*totalhours;
        }
        else
        {
            return 3*hourlywage*totalhours/2;
        }
    }
    
}

class PremiumEmployee extends employee
{
    int premiumfee, numofsales;
    
    public PremiumEmployee(String name, String surname, int insuranceno, int premiumfee, int numofsales)
    {
        super(name, surname, insuranceno);
        this.premiumfee = premiumfee;
        this.numofsales = numofsales;
    }

    @Override
    public int calulateSalary() {
        return numofsales*premiumfee;
    }
    
}

public class SalaryCalculatorApp {

    public static void main(String[] args) {
        employee[] employees = new employee[3];
        Scanner info = new Scanner(System.in);
        int input;
        
        for(int i = 0;i<3;i++)
        {
            System.out.println("Please choose employee type\n0:Salaried Employee\n1:Hourly Employee\n2:Premium Employee\n");
            input = info.nextInt();
            if(input == 0)
            {
                System.out.println("Please enter employee info with spaces in one line");
                System.out.println("Employee Name/Surname/Insuranceno/Weekly Wage: ");
                
                employees[i] = new SalariedEmployee(info.next(), info.next(), info.nextInt(), info.nextInt());
                System.out.println("Employee name: "+employees[i].name);
                System.out.println("Employee surname: "+employees[i].surname);
                System.out.println("Employee insuranceno: "+employees[i].insuranceno);
                System.out.println("Monthly Wage: "+employees[i].calulateSalary()+"\n");
            }
            else if(input == 1)
            {
                System.out.println("Please enter employee info with spaces in one line");
                System.out.println("Employee Name/Surname/Insuranceno/Hourly Wage/Total Hours: ");
                
                employees[i] = new HourlyEmployee(info.next(), info.next(), info.nextInt(), info.nextInt(), info.nextInt());
                System.out.println("Employee name: "+employees[i].name);
                System.out.println("Employee surname: "+employees[i].surname);
                System.out.println("Employee insuranceno: "+employees[i].insuranceno);
                System.out.println("Monthly Wage: "+employees[i].calulateSalary()+"\n");

            }
            else if(input == 2)
            {
                System.out.println("Please enter employee info with spaces in one line");
                System.out.println("Employee Name/Surname/Insuranceno/Premium Fee/Number of Sales: ");
                
                employees[i] = new PremiumEmployee(info.next(), info.next(), info.nextInt(), info.nextInt(), info.nextInt());
                System.out.println("Employee name: "+employees[i].name);
                System.out.println("Employee surname: "+employees[i].surname);
                System.out.println("Employee insuranceno: "+employees[i].insuranceno);
                System.out.println("Monthly Wage: "+employees[i].calulateSalary()+"\n");

            }
        }
    }

}
