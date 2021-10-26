package com.wwj231dev.salarycalcpl.controller;

import com.wwj231dev.salarycalcpl.model.SalaryInputData;
import com.wwj231dev.salarycalcpl.model.salarybreakdown.TotalSalaryBreakdown;
import com.wwj231dev.salarycalcpl.service.SalaryCalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class SalaryCalcRestController {
    private static final Logger logger = LoggerFactory.getLogger(SalaryCalcRestController.class);

    private final SalaryCalculatorService salaryCalculatorService;

    public SalaryCalcRestController(final SalaryCalculatorService salaryCalculatorService) {
        this.salaryCalculatorService = salaryCalculatorService;
    }

    @PostMapping("/breakdown-salary")
    public TotalSalaryBreakdown breakdownSalary(@RequestBody SalaryInputData salaryInputData){
        logger.info("SalaryCalcRestController.breakdownSalary, received param: [{}]", salaryInputData);
        var totalSalaryBreakdown = salaryCalculatorService.breakdownSalary(salaryInputData);
        return totalSalaryBreakdown;
    }

}
