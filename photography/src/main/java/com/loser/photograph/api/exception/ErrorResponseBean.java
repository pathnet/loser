package com.loser.photograph.api.exception;


import com.loser.photograph.utils.UiUtils;

public class ErrorResponseBean<T> {
    private String errorMessage;
    private int code;
    private String url;

    public ErrorResponseBean() {
        super();
    }

    public ErrorResponseBean(int code, String errorMessage) {
        this.errorMessage = errorMessage;
        this.code = code;
    }

    public ErrorResponseBean(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setUrl(String baseUrl, String url1, String url2, String url3) {
        this.url = baseUrl + UiUtils.getText(url1) + UiUtils.getText(url2) + UiUtils.getText(url3);
    }

    @Override
    public String toString() {
        return "ErrorResponseBean:\n【" + "errorMessage=" + errorMessage + "】\n【code=" + code + "】\n【url=" + url + "】";
    }
}
