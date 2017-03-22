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
    }
}
