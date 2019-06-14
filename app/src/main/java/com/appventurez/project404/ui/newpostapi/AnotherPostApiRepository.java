package com.appventurez.project404.ui.newpostapi;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.appventurez.project404.ui.newpostapi.api.AppRetrofit;
import com.appventurez.project404.ui.postapi.vo.ResponseStudentDetail;
import com.appventurez.project404.vo.GeneralResponse;
import com.appventurez.project404.vo.RequestDate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnotherPostApiRepository {
    public LiveData<GeneralResponse<ResponseStudentDetail>> getProfile(RequestDate input) {

        final MutableLiveData<GeneralResponse<ResponseStudentDetail>> data = new MutableLiveData<>();
        AppRetrofit.getInstance().getApiService().doDailyReport(input).enqueue(new Callback<GeneralResponse<ResponseStudentDetail>>() {
            @Override
            public void onResponse(Call<GeneralResponse<ResponseStudentDetail>> call, Response<GeneralResponse<ResponseStudentDetail>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<GeneralResponse<ResponseStudentDetail>> call, Throwable t) {
                data.setValue(null);
            }
        });

        return data;
    }

    public LiveData<IsdCodeResponse> getIsdList() {
        final MutableLiveData<IsdCodeResponse> data = new MutableLiveData<>();
        AppRetrofit.getInstance().getApiService().isdApi().enqueue(new Callback<IsdCodeResponse>() {
            @Override
            public void onResponse(Call<IsdCodeResponse> call, Response<IsdCodeResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<IsdCodeResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}

