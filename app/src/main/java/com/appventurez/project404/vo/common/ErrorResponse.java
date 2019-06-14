package com.appventurez.project404.vo.common;

/**
 * Pojo Generator
 * */
public class ErrorResponse {


    /**
     * status : false
     * message : failure
     * result : {"code":"5","message":"Invalid credentials.","data":{}}
     * responseCode : 400
     */

    private boolean status;
    private String message;
    private ResultBean result;
    private int responseCode;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public class ResultBean {

        /**
         * code : 5
         * message : Invalid credentials.
         */

        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}