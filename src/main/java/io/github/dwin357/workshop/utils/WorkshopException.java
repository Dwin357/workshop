/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dwin357.workshop.utils;

/**
 *
 * @author dwin
 */
public class WorkshopException extends Exception {

    public WorkshopException() {
    }

    public WorkshopException(String message) {
        super(message);
    }

    public WorkshopException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkshopException(Throwable cause) {
        super(cause);
    }

    public WorkshopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
