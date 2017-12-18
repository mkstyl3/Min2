package dsa.upc.edu.min2.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike on 18/12/17.
 */

public class Order implements Parcelable{
    //Variable declaration
    private List<Product> products;
    private int userId;


    //Constructors

    public Order(int userId, boolean served, List<Product> products) {
        this.userId = userId;
        this.products = products;
    }

    public Order () {
        this.products = new ArrayList<>();
    }

    //Getters and Setters

    protected Order(Parcel in) {
        products = in.createTypedArrayList(Product.CREATOR);
        userId = in.readInt();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct(int id) {
        return this.products.get(id);
    }

    public void setProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(products);
        parcel.writeInt(userId);
    }
}
