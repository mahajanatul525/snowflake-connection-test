package com.example.snowconnectiontest.service;

import com.example.snowconnectiontest.model.Rule;

import java.util.List;

public interface IRuleService {

    Rule getRuleById(String id);

    void SaveRule(Rule rule);

    List<Rule> getRules();
}
