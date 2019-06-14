package com.appventurez.project404.api;

import android.arch.lifecycle.LiveData;

import com.appventurez.project404.ui.ResponseActivity.vo.GetResponse;
import com.appventurez.project404.ui.postapi.vo.ResponseStudentDetail;
import com.appventurez.project404.vo.GeneralResponse;
import com.appventurez.project404.vo.RequestDate;
import com.appventurez.project404.vo.RequestStdId;
import com.appventurez.project404.vo.SimpleResponse;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

//import com.drivingschool.ui.ActivityLogin.vo.ResponseLogin;

/**
 * All API services, with their Url, Response type, Request type and Request method(eg. GET, POST)
 */
public interface AppService {

    @GET(ApiConstant.PROFILE)
    LiveData<ApiResponse<GeneralResponse<SimpleResponse<GetResponse>>>> doProfileData();

    @POST(ApiConstant.GET_STUDENT_DETAIL)
    LiveData<ApiResponse<GeneralResponse<SimpleResponse<ResponseStudentDetail>>>> doStdDetailDATA(@Body RequestStdId value);

    @POST(ApiConstant.GET_DAILY_REPORT)
    LiveData<ApiResponse<GeneralResponse<ResponseStudentDetail>>> doDailyReport(@Body RequestDate date);


}

