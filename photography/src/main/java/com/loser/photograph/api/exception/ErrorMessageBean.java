package com.loser.photograph.api.exception;

public class ErrorMessageBean {
    private String errorMessage;

    public ErrorMessageBean() {
        super();
    }

    public ErrorMessageBean(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
