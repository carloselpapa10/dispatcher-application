package com.example.dispatcher;

import com.example.dispatcher.Controller.EmployeeController;
import com.example.dispatcher.Model.EmployeeRepository;
import com.example.dispatcher.Service.DispatcherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DispatcherService dispatcherService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp(){

    }

    @Test
    public void processingTest() throws Exception{
        mvc.perform(get("/processing"))
                .andExpect(status().isOk());
    }

}
