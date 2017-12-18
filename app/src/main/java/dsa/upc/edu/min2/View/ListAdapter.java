package dsa.upc.edu.min2.View;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dsa.upc.edu.min2.Model.Product;
import dsa.upc.edu.min2.R;

/**
 * Created by root on 4/06/17.
 */

public class ListAdapter extends ArrayAdapter<Product> {

    List<Product> followerArrayList;
    Context context;
    int resource;

    public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.followerArrayList = objects;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.activity_itemlist, null, true);
            holder = new ViewHolder();
            holder.hImage1 = (ImageView) convertView.findViewById(R.id.productAvatarView);
            holder.hText1 = (TextView) convertView.findViewById(R.id.productNameView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = getItem(position);

        holder.hText1.setText(product.getName());
        Picasso.with(context).load("http://i.imgur.com/DvpvklR.png")
                .into(holder.hImage1);

        return convertView;
    }

    private static class ViewHolder
    {
        private ImageView hImage1;
        private TextView hText1;
    }
}
