package com.example.dispatcher;

import com.example.dispatcher.Model.Employee;
import com.example.dispatcher.Model.EmployeeRepository;
import com.example.dispatcher.Model.EmployeeType;
import com.example.dispatcher.Service.DispatcherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class DispatcherServiceTest {

    @TestConfiguration
    static class DispatcherServiceTestContextConfiguration{

        @Bean
        public DispatcherService dispatcherService(){
            return new DispatcherService();
        }
    }

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp(){
        Employee carlos = new Employee("carlos", EmployeeType.OPERATOR);

        Mockito.when(employeeRepository.findByName(carlos.getName()))
                .thenReturn(carlos);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound(){
        String name = "carlos";
        Employee found = employeeRepository.findByName(name);

        assertThat(found.getName())
                .isEqualTo(name);
    }

    @Test
    public void whenValidName_thenEmployeeTypeShouldBeFound(){
        String name = "carlos";
        Employee found = employeeRepository.findByName(name);

        assertThat(found.getEmployeeType()).isEqualTo(EmployeeType.OPERATOR.toString());

    }
}
