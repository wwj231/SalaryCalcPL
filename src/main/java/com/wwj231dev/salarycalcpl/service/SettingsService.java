package com.wwj231dev.salarycalcpl.service;

import com.wwj231dev.salarycalcpl.configuration.SettingsProperties;
import com.wwj231dev.salarycalcpl.model.TaxContributionSettings;
import com.wwj231dev.salarycalcpl.utils.FileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class SettingsService {

    private static final Logger logger = LoggerFactory.getLogger(SettingsService.class);

    private final FileManager fileManager;
    private final SettingsProperties settingsProperties;
    private final ConfigurableApplicationContext context;

    public SettingsService(final FileManager fileManager, final SettingsProperties settingsProperties, final ConfigurableApplicationContext context) {
        this.fileManager = fileManager;
        this.settingsProperties = settingsProperties;
        this.context = context;
    }

    public Optional<TaxContributionSettings> saveSettings(TaxContributionSettings taxContributionSettings){
        try {
            logger.info("SettingsService.saveSettings | Saving TaxContributionSettings : [{}]", taxContributionSettings);
            fileManager.exportData(taxContributionSettings, settingsProperties.getSettingsFilePath());
            logger.info("SettingsService.saveSettings | Updating TaxContributionSettings...");
            context.getBean(TaxContributionSettings.class).updateTaxContributionSettings(taxContributionSettings);
            logger.info("SettingsService.saveSettings | TaxContributionSettings updated.");
            return Optional.of(taxContributionSettings);
        } catch (IOException e) {
            logger.error("SettingsService.saveSettings | TaxContributionSettings not saved!.");
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<TaxContributionSettings> loadSettings() {
        try {
            logger.info("SettingsService.loadSettings | Loading TaxContributionSettings.");
            return Optional.of(fileManager.importData(TaxContributionSettings.class, settingsProperties.getSettingsFilePath()));
        } catch (IOException e) {
            logger.error("SettingsService.loadSettings | taxContributionSettings not loaded!");
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }
}
