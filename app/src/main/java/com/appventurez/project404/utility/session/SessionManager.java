package com.appventurez.project404.utility.session;

import android.app.Application;

import com.appventurez.project404.app.AppController;
import com.appventurez.project404.utility.PreferenceUtil;
import com.appventurez.project404.utility.constant.AppConstants;
import com.appventurez.project404.utility.constant.PrefConstant;


public class SessionManager {

    private static SessionManager sInstance;
    private PreferenceUtil pref;

    private SessionManager(Application application) {
        pref = new PreferenceUtil(application);
    }

    public static void init(Application application) {
        if (sInstance == null) {
            sInstance = new SessionManager(application);
        }
    }

    public static SessionManager get() {
       init(AppController.getInstance());
        return sInstance;
    }


    public void setUserName(String fname) {
        pref.setStringData(PrefConstant.USER_NAME, fname);
    }

    public String getUserName() {
        return pref.getStringData(PrefConstant.USER_NAME);
    }


    public void setUser(String fname) {
        pref.setStringData(PrefConstant.USER, fname);
    }

    public String getUser() {
        return pref.getStringData(PrefConstant.USER);
    }


    public void setPassword(String fname) {
        pref.setStringData(PrefConstant.PASSWORD, fname);
    }


    public String getPassword() {
        return pref.getStringData(PrefConstant.PASSWORD);
    }

    public void setLogInPassword(String fname) {
        pref.setStringData(PrefConstant.LOG_PASSWORD, fname);
    }


    public String getLogInPassword() {
        return pref.getStringData(PrefConstant.LOG_PASSWORD);
    }



    public boolean isRememberPermission() {
        return pref.getBoolean(PrefConstant.IS_REMEMBER);
    }

    public void setRememberPermission(boolean b) {
        pref.setBooleanData(PrefConstant.IS_REMEMBER, b);
    }





    public boolean isLoggedIn() {
        return pref.getBoolean(PrefConstant.IS_LOGGED_IN);
    }

    public void setLoggedIn(boolean b) {
        pref.setBooleanData(PrefConstant.IS_LOGGED_IN, b);
    }



    public String getInstrutionData() {
        return pref.getStringData(PrefConstant.INSTRUCTION_DATA);
    }

    public void setInstrutionData(String InstructionData) {
        pref.setStringData(PrefConstant.INSTRUCTION_DATA, InstructionData);
    }




    public String getEmail() {
        return pref.getStringData(PrefConstant.EMAIL);
    }

    public void setEmail(String EMAIL) {
        pref.setStringData(PrefConstant.EMAIL, EMAIL);
    }

    public void setMobile(String MOBILE) {
        pref.setStringData(PrefConstant.MOBILE, MOBILE);
    }
    public String getMobile() {
        return pref.getStringData(PrefConstant.MOBILE);
    }


    public String getMemCardNumber() {
        return pref.getStringData(PrefConstant.MemberCard);
    }

    public void setMemCardNumber(String MemberCard) {
        pref.setStringData(PrefConstant.MemberCard, MemberCard);
    }

    public String getDOB() {
        return pref.getStringData(PrefConstant.dob);
    }

    public void setDOB(String dob) {
        pref.setStringData(PrefConstant.dob, dob);
    }

    public String getCOUNTRYCODE() {
        return pref.getStringData(PrefConstant.COUNTRYCODE);
    }

    public void setCOUNTRYCODE(String COUNTRYCODE) {
        pref.setStringData(PrefConstant.COUNTRYCODE, COUNTRYCODE);
    }


    public boolean isGuest() {
        return pref.getBoolean(PrefConstant.IS_GUEST_USER);
    }

    public void setGUEST(boolean b) {
        pref.setBooleanData(PrefConstant.IS_GUEST_USER, b);
    }


    public String getAccessToken() {
        return pref.getStringData(PrefConstant.ACCESS_TOKEN);
    }

    public void setAccessToken(String accesstoken) {
        pref.setStringData(PrefConstant.ACCESS_TOKEN, accesstoken);
    }


    public String getOccationType() {
        return pref.getStringData(PrefConstant.OCCATION_TYPE);
    }

    public void setOccationType(String occationType) {
        pref.setStringData(PrefConstant.OCCATION_TYPE, occationType);
    }

    public String getOccationDate() {
        return pref.getStringData(PrefConstant.OCCATION_DATE);
    }

    public void setOccationDate(String occationDate) {
        pref.setStringData(PrefConstant.OCCATION_DATE, occationDate);
    }


    public int getOTP() {
        return pref.getIntData(PrefConstant.OTP);
    }

    public void setOTP(int otp) {
        pref.setIntData(PrefConstant.OTP, otp);
    }



    public int getStud_Id() {
        return pref.getIntData(PrefConstant.STUD_ID);
    }

    public void setStud_Id(int stud_id) {
        pref.setIntData(PrefConstant.STUD_ID, stud_id);
    }


    public String getAddress() {
        return pref.getStringData(PrefConstant.ADDRESS);
    }

    public int getUserId() {
        return pref.getIntData(PrefConstant.USER_ID);
    }

    public void setUserId(int userId) {
        pref.setIntData(PrefConstant.USER_ID, userId);
    }

    public String getMtype() {
        return pref.getStringData(PrefConstant.M_type);
    }

    public void setMType(String M_type) {
        pref.setStringData(PrefConstant.M_type, M_type);
    }


    public String getDummyString() {
        return pref.getStringData(PrefConstant.dummy);
    }

    public void setDummyString(String dummy) {
        pref.setStringData(PrefConstant.dummy, dummy);
    }


    public String getSavedDate() {
        return pref.getStringData(PrefConstant.SAVED_DATE);
    }

    public void setSavedDate(String savedDate) {
        pref.setStringData(PrefConstant.SAVED_DATE, savedDate);
    }


    public String getFirstName() {
        return pref.getStringData(PrefConstant.FIRST_NAME);
    }

    public void setFirstName(String fname) {
        pref.setStringData(PrefConstant.FIRST_NAME, fname);
    }

    public String getLanguageCode() {
        return pref.getStringData(PrefConstant.LANGUAGE_CODE);
    }

    public void setLanguageCode(String languageCode) {
        pref.setStringData(PrefConstant.LANGUAGE_CODE, languageCode);
    }



    public int getGender() {
        return pref.getIntData(PrefConstant.GENDER);
    }

    public void setGender(int GENDER) {
        pref.setIntData(PrefConstant.GENDER, GENDER);
    }


    public String getProfilePic() {
        return pref.getStringData(PrefConstant.PROFILE_PIC);
    }

    public void setProfilePic(String profilePic) {
        pref.setStringData(PrefConstant.PROFILE_PIC, profilePic);
    }




    public String getUserType() {
        return pref.getStringData(PrefConstant.USER_TYPE);
    }



    public void setUserType(String userType) {
        pref.setStringData(PrefConstant.USER_TYPE, userType);
    }


    public void setALREADYGUESTType(String userType) {
        pref.setStringData(PrefConstant.ALREADY_SIGNUP, userType);
    }

    public String getALREADYGUESTType() {
        return pref.getStringData(PrefConstant.ALREADY_SIGNUP);
    }

    public void setGuestUser(boolean isGuestUser) {
        pref.setBooleanData(PrefConstant.IS_GUEST_USER, isGuestUser);
    }

    public boolean isGuestuser() {
        return pref.getBoolean(PrefConstant.IS_GUEST_USER);
    }



    public String getFCMToken() {
        return pref.getStringData(AppConstants.FCM_DEVICE_TOKEN);
    }

    public void setFCMToken(String profilePic) {
        pref.setStringData(AppConstants.FCM_DEVICE_TOKEN, profilePic);
    }



//
//    public void saveGuestUserInfo(Context context, GuestUserResponse guestUserResponse) {
//        pref.setIntData(PrefConstant.USER_ID, guestUserResponse.getUserId());
//        pref.setIntData(PrefConstant.USER_TYPE, guestUserResponse.getUserType());
////        pref.save(JWTHelper.KEY_JWT_TOKEN, responseEntity.getToken());
////        pref.save(JWTHelper.KEY_TOKEN_LIFE_TIME_IN_MILI, responseEntity.getExpiresIn());
//        pref.setStringData(PrefConstant.FIRST_NAME, context.getString(R.string.lable_guest));
//        pref.setStringData(PrefConstant.LAST_NAME, "");
//        pref.setStringData(PrefConstant.LANGUAGE_CODE, guestUserResponse.getLanguageCode());
//        pref.setBooleanData(PrefConstant.IS_GUEST_USER, true);
//    }



//    public ArrayList<Offer> getOfferList() {
//        return pref.getArrayListOffer(PrefConstant.USER_TYPE);
//    }
//
//    public void setOfferList(ArrayList<Offer> userType) {
//        pref.saveArrayOfferList(PrefConstant.USER_TYPE, userType);
//    }



//    public ArrayList<ResponseOffer> getOfferListResult() {
//        return pref.getArrayListOfferResult(PrefConstant.USER_TYPE);
//    }
//
//    public void setOfferListResult(ArrayList<ResponseOffer> userType) {
//        pref.saveArrayOfferListResult(PrefConstant.USER_TYPE, userType);
//    }

    public void clear() {
        pref.clear();

    }
}
