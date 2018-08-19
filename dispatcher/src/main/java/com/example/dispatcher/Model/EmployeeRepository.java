package com.example.dispatcher.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByName(String name);

    /*Retorna un empleado dispobible (sí lo hay). */
    @Query(value = "SELECT * FROM Employee e " +
            "WHERE e.available= ? " +
            "ORDER BY e.employee_type = 'DIRECTOR',  " +
            "e.employee_type = 'SUPERVISOR', " +
            "e.employee_type = 'OPERATOR', " +
            "e.id ASC limit 1", nativeQuery = true)
    Employee findEmployeeByAvailable(Boolean Available);

    /*Actualiza el campo de disponibilidad del empleado*/
    @Modifying
    @Query("update Employee e set e.available = :available where e.id = :id")
    int updateEmployeeStatus(@Param("available") Boolean available, @Param("id") Long id) throws Exception;
}