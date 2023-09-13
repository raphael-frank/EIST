package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Employee {
    // TODO 2: Implement the Supervisor class
    private final List<Employee> supervisedEmployees;

    public Supervisor(String name) {
        super(name);
        supervisedEmployees = new ArrayList<>();
    }

    public List<Employee> getSupervisedEmployees() {
        return supervisedEmployees;
    }

    public void hireEmployee(Employee employee) {
        supervisedEmployees.add(employee);
    }

    public void fireEmployee(Employee employee) {
        supervisedEmployees.remove(employee);
    }

	// TODO 3: Implement listHierarchy() for Supervisor
    @Override
    public void listHierarchy(int level) {
        printName(level);
        supervisedEmployees.forEach(e -> e.listHierarchy(level + 1));
    }
}
