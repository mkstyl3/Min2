package dsa.upc.edu.min2.Controller;


import dsa.upc.edu.min2.Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by mike on 4/12/17.
 */

public interface ApiService {
    @POST("userLogin")
    Call<User> loginService(@Body User user);
}
