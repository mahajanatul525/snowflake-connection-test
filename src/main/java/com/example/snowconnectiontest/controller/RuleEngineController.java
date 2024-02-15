package com.example.snowconnectiontest.controller;

import com.example.snowconnectiontest.model.Rule;
import com.example.snowconnectiontest.service.IRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/services/rule-engine/")
public class RuleEngineController {
    @Autowired
    IRuleService ruleService;

    @GetMapping("/rules")
    public ResponseEntity<List<Rule>> fetchRules(){
        return new ResponseEntity<>(ruleService.getRules(), HttpStatus.OK);
    }

    @GetMapping("/rules/{id}")
    public ResponseEntity<Rule> fetchRuleById(@PathVariable String id){
        return new ResponseEntity<>(ruleService.getRuleById(id), HttpStatus.OK);
    }

    @PostMapping("/rules")
    public ResponseEntity<String> createNewRule(@RequestBody Rule rule){
        ruleService.SaveRule(rule);
        return new ResponseEntity<>("Success!! new rule created. ", HttpStatus.OK);
    }
}
