package com.wwj231dev.salarycalcpl.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class JsonFileManager implements FileManager{

    private static final Logger logger = LoggerFactory.getLogger(JsonFileManager.class);

    @Override
    public <T> T importData(final Class<T> tClass, final String filePath) throws IOException{
        logger.info("JsonFileManager.importData | Data received : [{}]  [{}]", tClass, filePath);
        String jsonArrString;
        StringBuilder sb = new StringBuilder();

        try (var reader = new BufferedReader(new FileReader(filePath))) {
            logger.info("JsonFileManager.importData | Building String from file");
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine);
            }
            jsonArrString = sb.toString();

            logger.info("JsonFileManager.importData | Building Object from String using ObjectMapper.");
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonArrString, tClass);
        } catch (FileNotFoundException fnfe){
            logger.error("File not found : [{}]", filePath);
            logger.error(fnfe.getMessage());
            throw new FileNotFoundException();
        } catch (IOException ioe){
            logger.error("Problems with processing file : [{}]", filePath);
            logger.error(ioe.getMessage());
            throw new IOException();
        }
    }

    @Override
    public <T> T exportData(final T toSave, final String filePath) throws IOException {
        logger.info("JsonFileManager.exportData | Received to save : [{}] to [{}]", toSave, filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), toSave);
            logger.info("JsonFileManager.exportData | Saved [{}] to [{}]", toSave, filePath);
            return toSave;
        } catch (IOException e) {
            logger.error("JsonFileManager.exportData | Problems with processing file : [{}]", filePath);
            throw new IOException();
        }
    }
}
