/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acentic.cloudservices.dev.jersey;

/**
 *
 * @author uli
 */
public class ErrorInfo {
    final transient String developerMessage;
    final transient String userMessage;

    public ErrorInfo(String developerMessage, String userMessage) {
        super();
        this.developerMessage = developerMessage;
        this.userMessage = userMessage;
    }

    ErrorInfo(Object object, String message, String message0, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }
    
    
    
}
