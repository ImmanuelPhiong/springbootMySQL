package com.impractice.springbootMySQL.entity.offices;

import com.impractice.springbootMySQL.entity.employees.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
}
