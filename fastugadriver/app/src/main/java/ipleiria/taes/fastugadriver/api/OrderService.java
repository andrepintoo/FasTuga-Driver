package ipleiria.taes.fastugadriver.api;

import java.util.List;

import ipleiria.taes.fastugadriver.model.order.OrderModelArray;
import ipleiria.taes.fastugadriver.model.order.OrderModelDataArray;
import ipleiria.taes.fastugadriver.model.order.OrderModelObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OrderService {
    @GET("orders")
    Call<List<OrderModelArray>> getOrders();
    /*
    OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);
                Call<OrderModelArray> orders = service.getOrders();

                orders.enqueue(new Callback<OrderModelArray>() {
                    @Override
                    public void onResponse(Call<OrderModelArray> call, Response<OrderModelArray> response) {
                        Log.e(TAG, "onResponse: code : " + response.code());
                        ArrayList<OrderModelArray.data> data = response.body().getOrders();
                        for (OrderModelArray.data order : data) {
                            Log.e(TAG, "onResponse: " + order.getDelivered_by());
                        }
                    }

                    @Override
                    public void onFailure(Call<OrderModelArray> call, Throwable t) {
                        Log.e(TAG, "onFaulure : "+ t.getMessage());
                    }
                });
     */

    @GET("orders/{id}")
    Call<OrderModelObject> getOrder(@Path("id") int id);
    /*
    OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);
                Call<OrderModelObject> order = service.getOrder(5);

                order.enqueue(new Callback<OrderModelObject>() {
                    @Override
                    public void onResponse(Call<OrderModelObject> call, Response<OrderModelObject> response) {
                        Log.e(TAG, "onResponse: code : " + response.code());
                        JsonObject order = response.body().getOrder();
                        JsonObject delivered_by = order.getAsJsonObject("delivered_by");
                        Log.e(TAG, "onResponse: order : " +  delivered_by.get("name"));
                    }

                    @Override
                    public void onFailure(Call<OrderModelObject> call, Throwable t) {
                        Log.e(TAG, "onFaulure : "+ t.getMessage());
                    }
                });
     */

    @GET("orders/status/{status}")
    Call<List<OrderModelArray>> getOrderByStatus(@Path("status") char status);
    /*
        OrderService service = RetrofitClient.getRetrofitInstance().create(OrderService.class);
        Call<List<OrderModelArray>> orders = service.getOrderByStatus('R');

        orders.enqueue(new Callback<List<OrderModelArray>>() {
            @Override
            public void onResponse(Call<List<OrderModelArray>> call, Response<List<OrderModelArray>> response) {
                Log.e(TAG, "onResponse: code : " + response.code());
                List<OrderModelArray> data = response.body();
                for (OrderModelArray order : data) {
                    Log.e(TAG, "onResponse: " + order.getId());
                    Log.e(TAG, "onResponse: " + order.getStatus());
                }
            }

            @Override
            public void onFailure(Call<List<OrderModelArray>> call, Throwable t) {
                Log.e(TAG, "onFailure : "+ t.getMessage());
            }
        });
     */
}
