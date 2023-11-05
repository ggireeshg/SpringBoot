package com.gireesh.dao;

import com.gireesh.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
}
