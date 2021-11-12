package com.wwj231dev.salarycalcpl.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;

public interface FileManager {
    <T> T importData(Class<T> tClass, String filePath) throws IOException;
    <T> T exportData(T toSave, String filePath) throws IOException;
}
