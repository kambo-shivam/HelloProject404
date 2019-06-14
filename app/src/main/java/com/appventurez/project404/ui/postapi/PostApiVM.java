package com.appventurez.project404.ui.postapi;

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
import com.appventurez.project404.vo.RequestStdId;
import com.appventurez.project404.vo.Resource;
import com.appventurez.project404.vo.SimpleResponse;

import java.util.Objects;

public class PostApiVM extends BaseViewModel {
    private LiveData<Resource<GeneralResponse<SimpleResponse<ResponseStudentDetail>>>> liveData;
    private MutableLiveData<RequestStdId> mutableLiveData = new MutableLiveData<>();
    private PostApiRepository postApiRepository;

    public PostApiVM(@NonNull Application application) {
        super(application);
        setData();
        postApiRepository = new PostApiRepository();

    }

    private void setData() {
        liveData = Transformations.switchMap(mutableLiveData, new Function<RequestStdId, LiveData<Resource<GeneralResponse<SimpleResponse<ResponseStudentDetail>>>>>() {
            @Override
            public LiveData<Resource<GeneralResponse<SimpleResponse<ResponseStudentDetail>>>> apply(RequestStdId input) {
                if (input == null) {
                    return AbsentLiveData.create();
                }
                return postApiRepository.hitPostApi(input);
            }
        });
    }

    public LiveData<Resource<GeneralResponse<SimpleResponse<ResponseStudentDetail>>>> getLiveData() {
        return liveData;
    }

    public RequestStdId getRequest(int i) {
        RequestStdId requestStdId = new RequestStdId();
        requestStdId.setStud_id(i);
        return requestStdId;
    }

    public void setRequest(RequestStdId request) {
        if (Objects.equals(this.mutableLiveData.getValue(), request)) {
            return;
        }
        this.mutableLiveData.setValue(request);
    }

}
