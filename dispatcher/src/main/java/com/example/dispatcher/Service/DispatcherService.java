package com.example.dispatcher.Service;

import com.example.dispatcher.Model.Employee;
import com.example.dispatcher.Model.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/*Esta clase implementa la clase Callable para permitir multiples llamadas. */
@Service
public class DispatcherService implements Callable<Void> {

    @Autowired
    private EmployeeRepository employeeRepository;

    private static AtomicInteger callId= new AtomicInteger(1);

    public static synchronized int getCallId() {
        return callId.getAndIncrement();
    }

    @Override
    public Void call() throws Exception {

        /* buscar empleado disponible*/
        Employee employee = searchAnEmployeer(getCallId());

        /*atender llamada*/
        dispatchCall(employee);
        return null;
    }

    /* Este método asigna un empleado a la llamada entrante. En caso de no haber algún empleado, lo hace esperar por 2 segundos para volver a buscar un empleado disponible.*/
    public synchronized Employee searchAnEmployeer(int id) throws Exception {
        System.out.println("Dispatching a call with callId: "+id);

        Employee employee = employeeRepository.findEmployeeByAvailable(true);

        if(employee == null){
            System.out.println("There are not any employees available. Wait a moment!!!");

            Thread.sleep(2000);
            return searchAnEmployeer(id);
        }else{
            employeeRepository.updateEmployeeStatus(false, employee.getId());
            employee.setCallId(id);
            return employee;
        }
    }

    /*Este método es utilizado por un empleado para atender una llamada...*/
    public void dispatchCall(Employee employee) throws Exception {

        System.out.println("CallId: "+employee.getCallId()+" is being attended by EmployeeId: "+employee.getId()+" ("+employee.getEmployeeType()+")");

        Random rand = new Random();
        int attentionTime = rand.nextInt(5) + 5;
        attentionTime = attentionTime*1000;

        Thread.sleep(attentionTime);
        employeeRepository.updateEmployeeStatus(true, employee.getId());
        System.out.println("EmployeeId: "+employee.getId()+" is available again! ");
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

}
