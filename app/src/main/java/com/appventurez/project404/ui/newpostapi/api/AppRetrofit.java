package com.appventurez.project404.ui.newpostapi.api;


import android.support.v7.app.AlertDialog;

import com.appventurez.project404.api.ApiConstant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRetrofit {

    private static AppRetrofit instance;
    private final ApiService apiService;
    private boolean isLogoutDialogShowing;
    private AlertDialog mAlertDialog;

    private AppRetrofit() {
        apiService = provideService();
    }

    private static void initInstance() {
        if (instance == null) {
            // Create the instance
            instance = new AppRetrofit();
        }
    }

    public static AppRetrofit getInstance() {
        // Return the instance
        initInstance();
        return instance;
    }

    public ApiService getApiService() {
        return apiService;
    }


    private synchronized ApiService provideService() {

        // To show the Api Request & Params
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
        httpClient.addInterceptor(logging).addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder requestBuilder = chain.request().newBuilder().addHeader(ApiConstant.KEY_CONTENT_TYPE, ApiConstant.CONTENT_TYPE)
                        /*.addHeader("Accept", "application/json")*/
                        .addHeader("accessToken", "UjGttt/jDp16l3SBr0lcgW03hFHua34lLaqE+ZZ3XUAVGvkC2K60KJCvo4py06+u8oslPVOsO6Fhmpfw23Dn5pkllPPudJEkgYVhj8/PoMVwjZupyqwm1qpr8pi1DJRrYV8xwQC7xf2z1BbajLLmGyTNZzvhE2HitUxuAExOFCXiOVhzAvRibbY05kS1E2KcraD5km9S+xCzFSTP0c8ltuV9TFuR+uGQpl0lNPeLGGgySsSz//NUj6mo8LCiNpt/P1paXImBKUmSVpjyvIUD5UDUXHo1geIXuuelU9xjPULIb9P4UbdZFwygXTOXPx2arMnrjypD7/aQP1hRFkyuEQ==");
                Request request = requestBuilder
//                        .addHeader("Accept", "application/json")
                        .build();
                return chain.proceed(request);

//                String bodyString = response.body().string();
//                Response localResponse = response.newBuilder()
//                        .body(ResponseBody.create(response.body().contentType(), bodyString))
//                        .build();
//                return response;
            }
        });
        return new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()).build().create(ApiService.class);
    }


}
