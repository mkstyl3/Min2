package dsa.upc.edu.min2.Controller;


import java.util.List;

import dsa.upc.edu.min2.Model.Product;
import dsa.upc.edu.min2.Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by mike on 4/12/17.
 */

public interface ApiService {
    @POST("orders/userLogin")
    Call<User> loginService(@Body User user);

    @GET("products/getAllSortedByCost")
    Call<List<Product>> getProductsService();

    @POST("orders/{id}/makeOrder")
    Call<Boolean> makeOrderService (@Path("id") int id, @Body List<Product> products);
}
