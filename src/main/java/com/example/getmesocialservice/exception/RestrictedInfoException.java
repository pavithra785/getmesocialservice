package com.example.getmesocialservice.exception;

public class RestrictedInfoException extends Exception{
    @Override
    public String getMessage(){
        return "Invalid user name";
    }
}
