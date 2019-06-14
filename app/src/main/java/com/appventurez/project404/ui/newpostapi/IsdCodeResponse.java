package com.appventurez.project404.ui.newpostapi;

import java.util.List;

/**
 * Created by himanshusharma on 24/2/17.
 */

public class IsdCodeResponse {

    /**
     * isSuccess : true
     * message : sample string 2
     * status : sample string 3
     * result : [{"CountryId":1,"CountryCode":"sample string 2","Name":"sample string 3","IsdCode":"sample string 4"},{"CountryId":1,"CountryCode":"sample string 2","Name":"sample string 3","IsdCode":"sample string 4"}]
     */
    private boolean isSuccess;
    private String message;
    private int status;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * CountryId : 1
         * CountryCode : sample string 2
         * Name : sample string 3
         * IsdCode : sample string 4
         */

        private int CountryId;
        private String CountryCode;
        private String Name;
        private String IsdCode;
        private String CountryFlag;


        public String getCountryFlag() {
            return CountryFlag;
        }

        public void setCountryFlag(String countryFlag) {
            CountryFlag = countryFlag;
        }


        public int getCountryId() {
            return CountryId;
        }

        public void setCountryId(int CountryId) {
            this.CountryId = CountryId;
        }

        public String getCountryCode() {
            return CountryCode;
        }

        public void setCountryCode(String CountryCode) {
            this.CountryCode = CountryCode;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getIsdCode() {
            return IsdCode;
        }

        public void setIsdCode(String IsdCode) {
            this.IsdCode = IsdCode;
        }
    }
}
