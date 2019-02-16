/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dwin357.workshop.fileFeeder;

import io.github.dwin357.workshop.utils.FriendlyErrors;
import io.github.dwin357.workshop.utils.WorkshopException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dwin
 */
public class FileFeeder {
    
    private static Logger scribe = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final String fileName;
    private final FileFed consumer;
    
    public FileFeeder(String file, FileFed fed) {
        fileName = file;
        consumer = fed;
    }
    
    public void go() throws WorkshopException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while( (line = br.readLine()) != null ) {
                consumer.takeLine(line);
            }
        } catch (IOException ex) {
            Map<String,Object> args = new HashMap<>();
            args.put("fileName", fileName);
            args.put("consumerClass", consumer.getClass());
            FriendlyErrors.throwWorkshopException("exception processing file", ex, args);
        }
    }
}
