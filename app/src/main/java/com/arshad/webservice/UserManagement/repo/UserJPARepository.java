package com.arshad.webservice.UserManagement.repo;

import com.arshad.webservice.UserManagement.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<User, Integer>  {
}

