/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dwin357.garage.runners;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dwin
 */
public class LoggerRunner {
    
    private static Logger scribe = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    public static void main(String[] args) {
        scribe.debug("maybe?");
        scribe.error("fail");
        scribe.info("no, really I'm vine");
    }
}
