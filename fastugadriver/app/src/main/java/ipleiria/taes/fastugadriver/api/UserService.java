package ipleiria.taes.fastugadriver.api;

import ipleiria.taes.fastugadriver.model.user.UserModelObject;
import ipleiria.taes.fastugadriver.model.user.UserModelArray;
import retrofit2.Call;
import retrofit2.http.GET;
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

}
