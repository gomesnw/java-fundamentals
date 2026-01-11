package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy/MM");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Enter the department's name: ");
        String name = sc.next();
        Department dep = new Department(name);
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.next();
        System.out.print("Level: ");
        String workerLevel = sc.next();
        WorkerLevel level1 = WorkerLevel.valueOf(workerLevel.toUpperCase());
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, level1, baseSalary, dep);

        System.out.print("How many contracts to this worker?: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter contract # " + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            String data = sc.next();
            System.out.println("Value per hour:");
            double valuePerHour = sc.nextDouble();
            System.out.println("Duration (hours):");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(LocalDate.parse(data, fmt2), valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.println("Enter year and month to calculate income (yyyy/MM): ");
        String data = sc.next();
        YearMonth date = YearMonth.parse(data, fmt1);
        int year = date.getYear();
        int month = date.getMonthValue();
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        double income = worker.income(year, month);
        System.out.println("Income for " + data + ": " + income);
        sc.close();
    }
}
