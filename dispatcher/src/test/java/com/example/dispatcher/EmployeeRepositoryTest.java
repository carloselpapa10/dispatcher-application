package com.example.dispatcher;

import com.example.dispatcher.Model.Employee;
import com.example.dispatcher.Model.EmployeeRepository;
import com.example.dispatcher.Model.EmployeeType;
import com.example.dispatcher.Service.DispatcherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @MockBean
    private DispatcherService dispatcherService;

    @Test
    public void whenFindByName_thenReturnEmployee(){
        Employee carlos = new Employee("carlos", EmployeeType.DIRECTOR);
        testEntityManager.persist(carlos);
        testEntityManager.flush();

        Employee found = employeeRepository.findByName(carlos.getName());

        assertThat(found.getName()).isEqualTo(carlos.getName());
    }

}
