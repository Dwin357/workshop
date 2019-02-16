/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dwin357.workshop.runners;

import io.github.dwin357.workshop.fileFeeder.FileFed;
import io.github.dwin357.workshop.fileFeeder.FileFeedConstants;
import io.github.dwin357.workshop.fileFeeder.FileFeeder;
import io.github.dwin357.workshop.utils.WorkshopException;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dwin
 */
public class FileFeederTest implements FileFeedConstants {
    
    private static Logger scribe = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private static class SribeImpl implements FileFed {
        @Override
        public void takeLine(String line) {
            scribe.debug("line is:{}", line);
        }        
    }
    
    public static void main(String[] args) {
        FileFeeder feed = new FileFeeder(SMALL_STRING, new SribeImpl());
        
        try {
            feed.go();
        } catch (WorkshopException e) {
            scribe.error("Issues", e);
        }
    }
    
}
