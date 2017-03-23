package org.arip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Arip Hidayat on 3/21/2017.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... strings) throws Exception {
        employeeRepository.save(new Employee("Arip", "Hidayat", "Awesome employee"));
        employeeRepository.save(new Employee("Frodo", "Baggins", "ring bearer"));
        employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
        employeeRepository.save(new Employee("Gandalf", "the Grey", "wizard"));
        employeeRepository.save(new Employee("Samwise", "Gamgee", "gardener"));
        employeeRepository.save(new Employee("Meriadoc", "Brandybuck", "pony rider"));
        employeeRepository.save(new Employee("Peregrin", "Took", "pipe smoker"));
    }
}
