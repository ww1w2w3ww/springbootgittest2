package com.example.workforspringboot.exception;

public class MyException extends RuntimeException {

    static final long serialVersionUID = 7818375828146090155L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);  // 把参数传递给Throwable的带String参数的构造方法
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
