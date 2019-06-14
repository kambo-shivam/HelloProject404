package com.appventurez.project404.ui.newpostapi;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.appventurez.project404.common.base.BaseViewModel;
import com.appventurez.project404.ui.postapi.vo.ResponseStudentDetail;
import com.appventurez.project404.utility.AbsentLiveData;
import com.appventurez.project404.vo.GeneralResponse;
import com.appventurez.project404.vo.RequestDate;

public class AnotherPostApiVM extends BaseViewModel {
    private MutableLiveData<RequestDate> requestDate;
    private MutableLiveData<Void> isdList;
    private LiveData<GeneralResponse<ResponseStudentDetail>> viewProfileResponse;
    private LiveData<IsdCodeResponse> isdResponse;
    private AnotherPostApiRepository repository;

    public AnotherPostApiVM(@NonNull Application application) {
        super(application);
        repository = new AnotherPostApiRepository();
        requestDate = new MutableLiveData<>();
        isdList = new MutableLiveData<>();
        viewProfileResponse = Transformations.switchMap(requestDate, new Function<RequestDate, LiveData<GeneralResponse<ResponseStudentDetail>>>() {
            @Override
            public LiveData<GeneralResponse<ResponseStudentDetail>> apply(RequestDate input) {
                if (input == null)
                    return AbsentLiveData.create();
                else
                    return repository.getProfile(input);
            }
        });
        isdResponse = Transformations.switchMap(isdList, input -> repository.getIsdList());
    }

    public LiveData<IsdCodeResponse> getIsdResponse() {
        return isdResponse;
    }

    public void setRequest(RequestDate request) {
        this.requestDate.setValue(request);
    }

    public LiveData<GeneralResponse<ResponseStudentDetail>> getResponseList() {
        return viewProfileResponse;
    }

    public void setIsdRequest() {
        this.isdList.setValue(null);
    }
}
