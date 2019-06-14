package com.appventurez.project404.ui.newpostapi.api;


import com.appventurez.project404.api.ApiConstant;
import com.appventurez.project404.ui.newpostapi.IsdCodeResponse;
import com.appventurez.project404.ui.postapi.vo.ResponseStudentDetail;
import com.appventurez.project404.vo.GeneralResponse;
import com.appventurez.project404.vo.RequestDate;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST(ApiConstant.GET_DAILY_REPORT)
    Call<GeneralResponse<ResponseStudentDetail>> doDailyReport(@Body RequestDate date);

    @POST(ApiConstant.ISD_CODE)
    Call<IsdCodeResponse> isdApi();

/*
    @POST(ApiConstant.GET_DAILY_REPORT)
    LiveData<ApiResponse<GeneralResponse<ResponseStudentDetail>>> doDailyReport(@Body RequestDate date);
*/


}
