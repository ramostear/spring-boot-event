package com.ramostear.repository;

import com.ramostear.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ramostear on 2019/5/31 0031.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
