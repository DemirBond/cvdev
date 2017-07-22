package com.szg_tech.cvdevaluator.rest.authentication;

import com.szg_tech.cvdevaluator.rest.responses.LoginResponse;
import com.szg_tech.cvdevaluator.rest.responses.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by ahmetkucuk on 3/17/17.
 */

public interface AuthenticationService {

    @POST("token")
    Call<LoginResponse> login(@Body String loginBody);


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("api/account/register")
    Call<Void> register(@Body String registerBody);
}
