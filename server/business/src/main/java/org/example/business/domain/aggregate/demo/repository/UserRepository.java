package org.example.business.domain.aggregate.demo.repository;

import org.example.business.domain.aggregate.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
