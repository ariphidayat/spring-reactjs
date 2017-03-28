package org.arip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Arip Hidayat on 3/21/2017.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public void run(String... strings) throws Exception {

        Manager arip  = managerRepository.save(new Manager("arip", "hidayat", "ROLE_MANAGER"));
        Manager alisiana = managerRepository.save(new Manager("alisiana", "ulfah", "ROLE_MANAGER"));

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken("arip", "doesn't matter",
                        AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

        employeeRepository.save(new Employee("Frodo", "Baggins", "ring bearer", arip));
        employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar", arip));
        employeeRepository.save(new Employee("Gandalf", "the Grey", "wizard", arip));

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken("alisiana", "doesn't matter",
                        AuthorityUtils.createAuthorityList("ROLE_MANAGER")));

        employeeRepository.save(new Employee("Samwise", "Gamgee", "gardener", alisiana));
        employeeRepository.save(new Employee("Meriadoc", "Brandybuck", "pony rider", alisiana));
        employeeRepository.save(new Employee("Peregrin", "Took", "pipe smoker", alisiana));

        SecurityContextHolder.clearContext();
    }
}
