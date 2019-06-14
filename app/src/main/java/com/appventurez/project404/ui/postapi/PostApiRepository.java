package com.appventurez.project404.ui.postapi;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.appventurez.project404.AppExecutors;
import com.appventurez.project404.api.ApiResponse;
import com.appventurez.project404.api.AppRetrofit;
import com.appventurez.project404.api.AppService;
import com.appventurez.project404.repository.NetworkBoundWtDbRes;
import com.appventurez.project404.ui.postapi.vo.ResponseStudentDetail;
import com.appventurez.project404.vo.GeneralResponse;
import com.appventurez.project404.vo.RequestStdId;
import com.appventurez.project404.vo.Resource;
import com.appventurez.project404.vo.SimpleResponse;

public class PostApiRepository {
    private AppExecutors appExecutors;
    private AppService appService;

    public PostApiRepository() {
        this.appExecutors = new AppExecutors();
        this.appService = AppRetrofit.getInstance().getAppService();
    }

    public LiveData<Resource<GeneralResponse<SimpleResponse<ResponseStudentDetail>>>> hitPostApi(RequestStdId input) {
        return new NetworkBoundWtDbRes<GeneralResponse<SimpleResponse<ResponseStudentDetail>>, GeneralResponse<SimpleResponse<ResponseStudentDetail>>>(appExecutors) {

            @NonNull
            @Override
            protected LiveData<ApiResponse<GeneralResponse<SimpleResponse<ResponseStudentDetail>>>> createCall() {

                System.out.println("===>Inside");
                return appService.doStdDetailDATA(input);
            }
        }.asLiveData();
    }

}
