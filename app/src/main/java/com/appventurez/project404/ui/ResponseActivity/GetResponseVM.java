package com.appventurez.project404.ui.ResponseActivity;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.appventurez.project404.common.base.BaseViewModel;
import com.appventurez.project404.ui.ResponseActivity.vo.GetResponse;
import com.appventurez.project404.utility.AbsentLiveData;
import com.appventurez.project404.vo.GeneralResponse;
import com.appventurez.project404.vo.Resource;
import com.appventurez.project404.vo.SimpleResponse;
import com.appventurez.project404.vo.common.BlankRequest;

import java.util.Objects;

public class GetResponseVM extends BaseViewModel {
    MutableLiveData<BlankRequest> mutableLiveData = new MutableLiveData<>();
    private LiveData<Resource<GeneralResponse<SimpleResponse<GetResponse>>>> profileResponseLiveData;
    GetResponseRepository getResponseRepository;


    public GetResponseVM(@NonNull Application application) {
        super(application);
        setLiveData();
        getResponseRepository = new GetResponseRepository();

    }

    private void setLiveData() {
        profileResponseLiveData = Transformations.switchMap(mutableLiveData, new Function<BlankRequest, LiveData<Resource<GeneralResponse<SimpleResponse<GetResponse>>>>>() {
            @Override
            public LiveData<Resource<GeneralResponse<SimpleResponse<GetResponse>>>> apply(BlankRequest input) {
                if (input == null)
                    return AbsentLiveData.create();
                else
                    return getResponseRepository.hitProfileApi(input);
            }

        });
    }

    public LiveData<Resource<GeneralResponse<SimpleResponse<GetResponse>>>> getProfileResponseLiveData() {
        return profileResponseLiveData;
    }

    public void setRequestLiveData(BlankRequest blankRequest) {
        if (Objects.equals(this.mutableLiveData.getValue(), blankRequest)) {
            return;
        }
        this.mutableLiveData.setValue(blankRequest);
    }
}
