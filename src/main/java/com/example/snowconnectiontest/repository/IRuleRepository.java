package com.example.snowconnectiontest.repository;

import com.example.snowconnectiontest.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.Optional;

public interface IRuleRepository extends JpaRepository<Rule, String> {
    @Override
    Optional<Rule> findById(String s);

    // @Procedure("MY_STORED_PROC")
    // String myStoreProc(String id);

    // @Query("")
    // Rule getRuleyDescAndName(String ip);

}
