package dsa.upc.edu.min2.View;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import dsa.upc.edu.min2.Controller.ApiAdapter;
import dsa.upc.edu.min2.Model.Order;
import dsa.upc.edu.min2.Model.Product;
import dsa.upc.edu.min2.Model.User;
import dsa.upc.edu.min2.R;
import retrofit2.Call;
import retrofit2.Response;

public class MakeOrder extends Activity implements View.OnClickListener  {

    private ProgressBar progressBar2;
    private TextView item1View;
    private TextView item2View;
    private Button orderButton;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        Intent intent = getIntent();
        user = intent.getParcelableExtra("user");
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.GONE);
        item1View = (EditText) findViewById(R.id.item1View);
        item2View = (EditText) findViewById(R.id.item2View);
        orderButton = (Button) findViewById(R.id.orderButton);
        orderButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (item1View.getText().length() != 0 && item2View.getText().length() != 0) {
            String item1Name = item1View.getText().toString();
            String item2Name = item2View.getText().toString();
            getMakeOrder(item1Name, item2Name);
        }
    }

    private void getMakeOrder(String item1Name, String item2Name) {

        progressBar2.setVisibility(View.VISIBLE);
        progressBar2.setProgress(10);
        List<Product> products = new ArrayList<>();
        Product p1 = new Product();
        Product p2 = new Product();
        p1.setName(item1Name);
        p2.setName(item2Name);
        products.add(p1);
        products.add(p2);

        Call<Boolean> call = ApiAdapter.getApiService("http://10.0.2.2:8080/min1/").makeOrderService(user.getId(), products);
        call.enqueue(new GetMakeOrderCallback());
    }

    private class GetMakeOrderCallback implements retrofit2.Callback<Boolean> {
        @Override
        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
            Toast.makeText(getBaseContext(), "An order has been added. We got a "+response.body()+" from server.", Toast.LENGTH_SHORT).show();
            progressBar2.setProgress(100);

            finish();
        }

        @Override
        public void onFailure(Call<Boolean> call, Throwable t) {

        }
    }
}
