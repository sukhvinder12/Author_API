package com.webservice.server.Exceptions;

public class NoRecordsException extends RuntimeException {
    public NoRecordsException(String msg){
        super(msg);
    }
}
