package com.app.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.test.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
   User findByUsername(String username);
}
