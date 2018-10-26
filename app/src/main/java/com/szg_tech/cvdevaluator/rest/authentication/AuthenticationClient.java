package com.szg_tech.cvdevaluator.rest.authentication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.szg_tech.cvdevaluator.rest.api.RestClient;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public class AuthenticationClient {


    private AuthenticationService authenticationService;

    public AuthenticationClient() {
        Gson gson = new GsonBuilder()
                .create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder
                .addInterceptor(logging)
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();


        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(RestClient.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        authenticationService = restAdapter.create(AuthenticationService.class);
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}
