package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }
    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income (int year, int month){
        double totalSalary = baseSalary;
        for (HourContract contract: contracts){
            int contractYear = contract.getDate().getYear();
            int contractMonth = contract.getDate().getMonthValue();
            if(contractYear == year && contractMonth == month){
                totalSalary += contract.totalValue();
            }
        }
        return totalSalary;
    }
}
