package com.nickrankin.ca1.CA1.Web.Services.repository;

import com.nickrankin.ca1.CA1.Web.Services.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findUserByPpsNumber(String ppsNumber);
}
