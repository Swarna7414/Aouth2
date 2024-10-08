package com.Outh.Autht.Repository;

import com.Outh.Autht.Model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomUser,String> {
}
