package com.example.snowconnectiontest.repository;

import java.util.Map;

import org.hibernate.type.SqlTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class QueryGeneratorRepositoryImpl implements IQueryGeneratorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    void init() {
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("RULE_ENGINE_SCHEMA")
                .withProcedureName("get_rules").declareParameters(new SqlParameter("table_name", SqlTypes.VARCHAR));
    }

    @Override
    public void testProce() {

        SqlParameterSource in = new MapSqlParameterSource().addValue("table_name", "Rule");

        Map<String, Object> out = simpleJdbcCall.execute(in);

        String rawResponse = out.get("#result-set-1").toString();

        System.out.println("rawResponse" + rawResponse);
    }

}
