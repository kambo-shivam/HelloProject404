package com.appventurez.project404.api;


import com.appventurez.project404.BuildConfig;
import com.appventurez.project404.utility.LiveDataCallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRetrofit {
    private String token = "";
    private static AppRetrofit instance;

    public AppService getAppService() {
        return appService;
    }

    private final AppService appService;

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

    private AppRetrofit() {
        appService = provideService();
    }

    private AppService provideService() {


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
                        .addHeader("Accept", "application/json")
                        .addHeader("accessToken", "eyJhbGciOiJIUzI1NiJ9.MTA3.zk24sJ4BMyyXe7HwHTat5Ef6iD05p3GGl6FNr_jfV-E");
                Request request = requestBuilder
//                        .addHeader("Accept", "application/json")
                        .build();
                Response response = chain.proceed(request);

                if (!response.isSuccessful() && (response.code() == 401 || response.code() == 403)) {
                    Request newReq = request.newBuilder()
//                            .addHeader(ApiConstant.KEY_CONTENT_TYPE, ApiConstant.CONTENT_TYPE)
//                            .addHeader(AppConstants.X_TOKEN_KEY, JWTHelper.generateJwtToken())
                            .build();
                    response = chain.proceed(newReq);

                }
                return response;

            }
        });


        return new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .client(httpClient.build()).build().create(AppService.class);
    }

    public AppService getAppService(Converter.Factory gsonConverter) {
        // To show the Api Request & Params
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        return new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_URL)
                .addConverterFactory(gsonConverter)
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .client(httpClient.build())
                .build()
                .create(AppService.class);
/*
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build()).build().create(AppService.class);*/
    }
}




