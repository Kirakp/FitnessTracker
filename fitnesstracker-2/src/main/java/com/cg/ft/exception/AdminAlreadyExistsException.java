package com.cg.ft.exception;

public class AdminAlreadyExistsException extends RuntimeException{
    public AdminAlreadyExistsException(String msg){
        super(msg);
    }
}
