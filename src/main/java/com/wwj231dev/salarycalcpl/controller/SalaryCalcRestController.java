package com.wwj231dev.salarycalcpl.controller;

import com.wwj231dev.salarycalcpl.model.SalaryInputData;
import com.wwj231dev.salarycalcpl.model.TaxContributionSettings;
import com.wwj231dev.salarycalcpl.model.salarybreakdown.TotalSalaryBreakdown;
import com.wwj231dev.salarycalcpl.service.SalaryCalculatorService;
import com.wwj231dev.salarycalcpl.service.SettingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salarycalcpl")
public class SalaryCalcRestController {
    private static final Logger logger = LoggerFactory.getLogger(SalaryCalcRestController.class);

    private final SalaryCalculatorService salaryCalculatorService;
    private final SettingsService settingsService;

    public SalaryCalcRestController(final SalaryCalculatorService salaryCalculatorService, final SettingsService settingsService) {
        this.salaryCalculatorService = salaryCalculatorService;
        this.settingsService = settingsService;
    }

    @PostMapping("/breakdown-salary")
    public TotalSalaryBreakdown postBreakdownSalary(@RequestBody SalaryInputData salaryInputData){
        logger.info("SalaryCalcRestController.breakdownSalary(), received param: [{}]", salaryInputData);
        return salaryCalculatorService.breakdownSalary(salaryInputData);
    }

    @PostMapping("/post-tax-contribution-settings")
    public ResponseEntity<TaxContributionSettings> postSettings(@RequestBody TaxContributionSettings taxContributionSettings){
        logger.info("SalaryCalcRestController.postSettings(), received param: [{}]", taxContributionSettings);
        var optionalTaxContributionSettings = settingsService.saveSettings(taxContributionSettings);
        return optionalTaxContributionSettings.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(taxContributionSettings, HttpStatus.NOT_MODIFIED));
    }

    @GetMapping("/get-tax-contribution-settings")
    public ResponseEntity<TaxContributionSettings> getSettings(){
        logger.info("SalaryCalcRestController.getSettings()");
        var optionalTaxContributionSettings = settingsService.loadSettings();
        return optionalTaxContributionSettings.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
