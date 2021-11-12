package com.wwj231dev.salarycalcpl.configuration;

import com.wwj231dev.salarycalcpl.model.TaxContributionSettings;
import com.wwj231dev.salarycalcpl.utils.FileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class SettingsConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(SettingsConfiguration.class);

    private final ConfigurableApplicationContext context;
    private final SettingsProperties settingsProperties;

    public SettingsConfiguration(final ConfigurableApplicationContext context, final SettingsProperties settingsProperties) {
        this.context = context;
        this.settingsProperties = settingsProperties;
    }

    private FileManager fileManager;

    @Bean
    public TaxContributionSettings taxContributionSettings(){
        try {
            logger.info("SettingsConfiguration.taxContributionSettings | Importing TaxContributionSettings.");
            return fileManager.importData(TaxContributionSettings.class, settingsProperties.getSettingsFilePath());
        } catch (IOException e) {
            logger.error("SettingsConfiguration.taxContributionSettings | taxContributionSettings not loaded! - program ends.");
            System.exit(SpringApplication.exit(context));
        }
        return null;
    }

    @Autowired
    public void setFileManager(final FileManager fileManager) {
        this.fileManager = fileManager;
    }
}
