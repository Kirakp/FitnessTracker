package com.cg.ft.exception;

public class AdminNotFoundException extends RuntimeException{
    public AdminNotFoundException(String msg){
        super(msg);
    }
}
