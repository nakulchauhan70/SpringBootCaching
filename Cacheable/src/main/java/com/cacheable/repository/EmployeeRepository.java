package com.cacheable.repository;

import com.cacheable.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Transactional
    @Modifying
    @Query("update Employee emp set emp.address=?2 where emp.id=?1")
    int updateAddress(long id, String address);
}


//public interface EmployeeRepository extends CrudRepository<Employee, Long> {}
