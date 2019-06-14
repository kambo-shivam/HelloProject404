package com.appventurez.project404.ui.postapi;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.appventurez.project404.R;
import com.appventurez.project404.common.base.BaseActivity;
import com.appventurez.project404.databinding.ActivityPostApiBinding;
import com.appventurez.project404.ui.postapi.vo.ResponseStudentDetail;
import com.appventurez.project404.utility.DialogUtil;
import com.appventurez.project404.utility.network.NetworkHandler;
import com.appventurez.project404.vo.GeneralResponse;
import com.appventurez.project404.vo.Resource;
import com.appventurez.project404.vo.SimpleResponse;
import com.appventurez.project404.vo.Status;

public class PostApiActivity extends BaseActivity {
    ActivityPostApiBinding mBinding;
    PostApiVM postApiVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_post_api);
        postApiVM = ViewModelProviders.of(this).get(PostApiVM.class);
        hitPostApi();
    }

    private void hitPostApi() {
        if (NetworkHandler.isConnected()) {
            showHideProgressBar(true);
            postApiVM.setRequest(postApiVM.getRequest(21723));
            postApiVM.getLiveData().observe(this, generalResponseResource -> {
                if (generalResponseResource != null && generalResponseResource.status != Status.LOADING) {
                    showHideProgressDialog(false);
                    handleStudentDeatilResponse(generalResponseResource);
                }
            });
        } else
            Toast.makeText(mThis, "connect internet", Toast.LENGTH_SHORT).show();
    }

    private void handleStudentDeatilResponse(Resource<GeneralResponse<SimpleResponse<ResponseStudentDetail>>> generalResponseResource) {
        if (generalResponseResource.status == Status.SUCCESS && generalResponseResource.data != null) {
            if (generalResponseResource.data.isStatus() && generalResponseResource.data.getResult().getData() != null) {
                // setStdDetailData(generalResponseResource.data.getResult().getData());
                Toast.makeText(mThis, "Hello", Toast.LENGTH_SHORT).show();
            } else {
                DialogUtil.showSnackBar(mBinding.getRoot(), "No Data here");
            }
        } else if (generalResponseResource.status == Status.ERROR) {

        }
    }
}
