package io.bridgelabz.codinclub.api;

import io.bridgelabz.codinclub.dtos.AddUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface UserService {

    @POST("user/register")
    Call<Response>addUser(@Body AddUser addUser);

    @GET("user/app-config")
    Call<Response>appConfiguration();

    @GET("user/otp/generate")
    Call<Response>otpGenerate(@Query("mobileNumber")String mobileNumber);

    @POST("user/otp/verify")
    Call<Response>verityOtp(@Query("mobileNumber") String mobileNumber,@Query("otp") String otp);

    @POST("user/refresh-token")
    Call<Response>refreshToken(@Query("token")String token);

    @PUT("user/update")
    Call<Response>updateUser();

    @GET("user/user-config")
    Call<Response>userConfiguration(@Query("token")String token);

}
