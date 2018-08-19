package com.example.dispatcher.Controller;

import com.example.dispatcher.Model.Employee;
import com.example.dispatcher.Service.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class EmployeeController {

    @Autowired
    private DispatcherService dispatcherService;

    @Value("${thread.number}")
    private int threadNumber;

    @Value("${calls.number}")
    private int callsNumber;

    @GetMapping("test")
    public String test(){
        return "Test";
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return dispatcherService.findAllEmployees();
    }

    @GetMapping("/processing")
    public void processing() throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(threadNumber);

        for(int i=1; i<=callsNumber; i++){
            service.submit(dispatcherService);
        }

    }
}
