package com.rzpt.exception;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super(("用户不存在!"));
    }
}
