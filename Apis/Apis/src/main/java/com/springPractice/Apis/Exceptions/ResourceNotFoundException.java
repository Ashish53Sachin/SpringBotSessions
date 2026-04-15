package com.springPractice.Apis.Exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg, long id)
    {
        super(msg);
    }
}
