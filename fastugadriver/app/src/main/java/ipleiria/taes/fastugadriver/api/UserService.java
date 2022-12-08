package ipleiria.taes.fastugadriver.api;

import ipleiria.taes.fastugadriver.model.user.UserModelObject;
import ipleiria.taes.fastugadriver.model.user.UserModelArray;
import ipleiria.taes.fastugadriver.model.user.UserNameModelArray;
import ipleiria.taes.fastugadriver.model.user.UserPasswordModelArray;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("users")
    Call<UserModelArray> getUsers();
    /*
    UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);
                Call<UserModelArray> user = service.getUsers();

                user.enqueue(new Callback<UserModelArray>() {
                    @Override
                    public void onResponse(Call<UserModelArray> call, Response<UserModelArray> response) {
                        Log.e(TAG, "onResponse: code : " + response.code());
                        ArrayList<UserModelArray.data> data = response.body().getUsers();
                        for (UserModelArray.data user : data) {
                            Log.e(TAG, "onResponse: emails : " + user.getEmail() );
                        }
                    }

                    @Override
                    public void onFailure(Call<UserModelArray> call, Throwable t) {
                        Log.e(TAG, "onFaulure : "+ t.getMessage());
                    }
                });
     */

    @GET("users/{id}")
    Call<UserModelObject> getUser(@Path("id") int id);
        /*
    UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);
                Call<UserModelObject> user = service.getUser(1);

                user.enqueue(new Callback<UserModelObject>() {
                    @Override
                    public void onResponse(Call<UserModelObject> call, Response<UserModelObject> response) {
                        Log.e(TAG, "onResponse: code : " + response.code());
                        JsonObject user = response.body().getUser();
                        Log.e(TAG, "onResponse: emails : " +  user.get("email"));
                    }

                    @Override
                    public void onFailure(Call<UserModelObject> call, Throwable t) {
                        Log.e(TAG, "onFailure : "+ t.getMessage());
                    }
                });
     */

    @Headers({"Content-Type: application/json"})
    @DELETE("users/{email}")
    Call<ResponseBody> deleteUser(@Path("email") String email);

    @GET("users/{email}")
    Call<UserModelArray> getUserByEmail(@Path("email") String email);

    @Headers({"Content-Type: application/json"})
    @PUT("users/updateNameTAES/{email}")
    Call<ResponseBody> updateUserName(@Path("email") String email, @Body UserNameModelArray body);

    @Headers({"Content-Type: application/json"})
    @PUT("users/updatePasswordTAES/{email}")
    Call<ResponseBody> updateUserPassword(@Path("email") String email, @Body UserPasswordModelArray body);

}
