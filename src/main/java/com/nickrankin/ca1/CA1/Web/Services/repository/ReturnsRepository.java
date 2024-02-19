package com.nickrankin.ca1.CA1.Web.Services.repository;

import com.nickrankin.ca1.CA1.Web.Services.model.Return;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnsRepository extends JpaRepository<Return, Long> {
}
