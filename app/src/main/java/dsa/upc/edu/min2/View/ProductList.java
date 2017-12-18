package dsa.upc.edu.min2.View;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dsa.upc.edu.min2.Model.Product;
import dsa.upc.edu.min2.R;

public class ProductList extends Activity {

    Intent intent;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        intent = getIntent();
        List<Product> products = intent.getParcelableArrayListExtra("products");
        lv = (ListView) findViewById(R.id.productView);
        ListAdapter adapter = new ListAdapter(
                getApplicationContext(), R.layout.activity_product_list, products
        );
        lv.setAdapter(adapter);
    }
}
