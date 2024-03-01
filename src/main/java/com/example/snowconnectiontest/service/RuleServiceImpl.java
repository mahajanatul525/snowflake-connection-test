package com.example.snowconnectiontest.service;

import com.example.snowconnectiontest.model.Rule;
import com.example.snowconnectiontest.repository.IRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements IRuleService {
    @Autowired
    private IRuleRepository repo;



    @Override
    public void SaveRule(Rule rule) {

        //logic to apply berore inserting any record. 

        if(rule.getRuleId() != null){

        }

        repo.save(rule);
    }

    @Override
    public List<Rule> getRules() {
        return repo.findAll();
    }

    @Override
    public Rule getRuleById(String id) {
        return repo.findById(id).orElse(null);
    }
}
