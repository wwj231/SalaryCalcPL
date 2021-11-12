package com.wwj231dev.salarycalcpl.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "settings")
public class SettingsProperties {
    private String settingsFilePath;

    public SettingsProperties() {
    }

    public String getSettingsFilePath() {
        return settingsFilePath;
    }

    public void setSettingsFilePath(final String settingsFilePath) {
        this.settingsFilePath = settingsFilePath;
    }

    @Override
    public String toString() {
        return "SettingsProperties{" +
                "settingsFilePath='" + settingsFilePath + '\'' +
                '}';
    }
}
