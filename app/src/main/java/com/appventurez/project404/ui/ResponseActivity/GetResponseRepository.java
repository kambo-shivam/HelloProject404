package com.appventurez.project404.ui.ResponseActivity;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.appventurez.project404.AppExecutors;
import com.appventurez.project404.api.ApiResponse;
import com.appventurez.project404.api.AppRetrofit;
import com.appventurez.project404.api.AppService;
import com.appventurez.project404.repository.NetworkBoundWtDbRes;
import com.appventurez.project404.ui.ResponseActivity.vo.GetResponse;
import com.appventurez.project404.vo.GeneralResponse;
import com.appventurez.project404.vo.Resource;
import com.appventurez.project404.vo.SimpleResponse;
import com.appventurez.project404.vo.common.BlankRequest;

public class GetResponseRepository {
    AppExecutors appExecutors;
    AppService appService;

    public GetResponseRepository() {
        this.appExecutors = new AppExecutors();
        this.appService = AppRetrofit.getInstance().getAppService();
    }


    public LiveData<Resource<GeneralResponse<SimpleResponse<GetResponse>>>> hitProfileApi(final BlankRequest requestLogin) {
        return new NetworkBoundWtDbRes<GeneralResponse<SimpleResponse<GetResponse>>, GeneralResponse<SimpleResponse<GetResponse>>>(appExecutors) {

            @NonNull
            @Override
            protected LiveData<ApiResponse<GeneralResponse<SimpleResponse<GetResponse>>>> createCall() {
                return appService.doProfileData();//"{\"username\":\"jwright\",\"userpassword\":\"driver\"}"
            }
        }.asLiveData();
    }
}
