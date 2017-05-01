package com.si.mynews.model.http.response;

/**
 * Created by codeest on 16/11/27.
 */

public class NewsHttpResponse<T> {

    private T result;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
