package com.xfragwork.xfragwork.network.exception;

import com.google.gson.JsonSyntaxException;
import com.xfragwork.xfragwork.utils.GsonTools;
import com.xfragwork.xfragwork.utils.LogUtils;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.text.ParseException;

import okhttp3.ResponseBody;
import retrofit2.HttpException;
import retrofit2.Response;


public class ErrorHandler {

    public static ErrorResponseBean getErrorMessage(Throwable throwable) {
        try {
            if (throwable instanceof HttpException) {
                HttpException error = (HttpException) throwable;
                Response<?> response = error.response();
                ResponseBody responseBody = response.errorBody();
                ErrorResponseBean errorMessageBean = GsonTools.changeGsonToBean(responseBody.string(), ErrorResponseBean.class);
                errorMessageBean.setCode(error.code());
                LogUtils.e(ErrorHandler.class, throwable.getMessage());
                return errorMessageBean;
            } else if (throwable instanceof ResultException) {    //服务器返回的错误
                ResultException resultException = (ResultException) throwable;
                LogUtils.e(ErrorHandler.class, throwable.getMessage());
                return new ErrorResponseBean(resultException.getErrCode(), throwable.getMessage());
            } else if (throwable instanceof JsonSyntaxException || throwable instanceof JSONException || throwable instanceof ParseException) {
                LogUtils.e(ErrorHandler.class, throwable.getMessage());
                return new ErrorResponseBean(502, "解析错误");
            } else if (throwable instanceof SocketTimeoutException) {
                LogUtils.e(ErrorHandler.class, throwable.getMessage());
                return new ErrorResponseBean(500, "请求超时");
            } else if (throwable instanceof ServerException) {
                ServerException resultException = (ServerException) throwable;
                return new ErrorResponseBean(resultException.getCode(), resultException.getMessage());
            } else {
                LogUtils.e(ErrorHandler.class, throwable.getMessage());
                return new ErrorResponseBean(501, "网络异常,请稍后再试");
            }
        } catch (Exception e) {
            LogUtils.e(ErrorHandler.class, e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}