package com.appventurez.project404.ui.ResponseActivity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.databinding.ActivityGetResponseBinding;
import com.appventurez.project404.ui.ResponseActivity.vo.GetResponse;
import com.appventurez.project404.vo.GeneralResponse;
import com.appventurez.project404.vo.Resource;
import com.appventurez.project404.vo.SimpleResponse;
import com.appventurez.project404.vo.Status;
import com.appventurez.project404.vo.common.BlankRequest;

public class GetResponseActivity extends AppCompatActivity {
    ActivityGetResponseBinding activityGetResponseBinding;
    GetResponseVM getResponseVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGetResponseBinding = DataBindingUtil.setContentView(this, R.layout.activity_get_response);
        getResponseVM = ViewModelProviders.of(this).get(GetResponseVM.class);
        hitProfileApi();

    }

    private void hitProfileApi() {

        if (getResponseVM.getProfileResponseLiveData().hasObservers())
            getResponseVM.getProfileResponseLiveData().removeObservers(this);
        getResponseVM.setRequestLiveData(new BlankRequest());
        getResponseVM.getProfileResponseLiveData().observe(this, generalResponseResource -> {
            if (generalResponseResource != null && generalResponseResource.status != Status.LOADING) {
                //      showHideProgressDialog(false);
                handleGuestUserResponse(generalResponseResource);
            }
        });


    }

    private void handleGuestUserResponse(Resource<GeneralResponse<SimpleResponse<GetResponse>>> generalResponseResource) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}
