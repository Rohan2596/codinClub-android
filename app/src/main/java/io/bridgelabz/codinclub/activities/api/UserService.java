package io.bridgelabz.codinclub.activities.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UserService {

    @POST("register")
    Call<Response>addUser();

    @GET("/user/app-config")
    Call<Response>appConfiguration();

    @POST("/user/otp/generate")
    Call<Response>otpGenerate(String mobileNumber);

    @POST("/user/refresh-token")
    Call<Response>refreshToken(String token);

    @PUT("/user/update")
    Call<Response>updateUser();

    @GET("/user/user-config")
    Call<Response>userConfiguration(String token);

}
