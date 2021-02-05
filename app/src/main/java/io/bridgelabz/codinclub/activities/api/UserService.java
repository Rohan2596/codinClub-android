package io.bridgelabz.codinclub.activities.api;

import retrofit2.Call;
import retrofit2.http.POST;

public interface UserService {

    @POST("register")
    Call<Object>addUser();
}
