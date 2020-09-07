package com.cacheable.redis.repository;

import com.cacheable.redis.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Transactional
    @Modifying
    @Query("update Employee u set u.name=?2 where u.id=?1")
    int updateAddress(long id, String name);
}


//public interface EmployeeRepository extends CrudRepository<Employee, Long> {}
