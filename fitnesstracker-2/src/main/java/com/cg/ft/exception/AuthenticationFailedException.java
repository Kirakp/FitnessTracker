package com.cg.ft.exception;

public class AuthenticationFailedException extends RuntimeException{
    public AuthenticationFailedException(String msg){
        super(msg);
    }
}
