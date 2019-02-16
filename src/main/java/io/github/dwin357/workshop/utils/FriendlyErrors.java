/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dwin357.workshop.utils;

import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author dwin
 */
public class FriendlyErrors {
    
    public static String formatMsg(String msg, Map<String, Object> args) {
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        sb.append(" args:{ ");
        for(Entry<String,Object> arg : args.entrySet()) {
            sb.append(arg.getKey());
            sb.append("[");
            sb.append(arg.getValue().getClass() != null ? arg.getValue().getClass() : " ");
            sb.append("]:");
            sb.append(arg.getValue());
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
    
    public static <E extends Exception> void throwWorkshopException(String msg, E er, Map<String, Object> args) throws WorkshopException {
        throw new WorkshopException(formatMsg(msg, args), er);
    }
    
    public static <E extends Exception> void throwWorkshopException(String msg, E er) throws WorkshopException {
        throw new WorkshopException(formatMsg(msg, null), er);
    }
    
    public static void throwWorkshopException(String msg, Map<String, Object> args) throws WorkshopException {
        throw new WorkshopException(formatMsg(msg, args));
    }
    
    public static void throwWorkshopException(String msg) throws WorkshopException {
        throw new WorkshopException(formatMsg(msg, null));
    } 

    public static void throwWorkshopException() throws WorkshopException {
        throw new WorkshopException();
    }     
}
