package com.example.snowconnectiontest.repository;

import com.example.snowconnectiontest.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRuleRepository extends JpaRepository<Rule,String> {
    @Override
    Optional<Rule> findById(String s);


}
