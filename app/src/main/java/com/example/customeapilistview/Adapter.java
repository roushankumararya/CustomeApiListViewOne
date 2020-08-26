package com.example.customeapilistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.customeapilistview.model.MyPojo;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private MyPojo[] DataList;
   // ImageLoader imageLoader = Controller.getPermission().getImageLoader();

    public Adapter(Activity activity, MyPojo[] dataitem) {
        this.activity = activity;
        this.DataList = dataitem;
    }

    @Override
    public int getCount() {
        return DataList.length;
    }

    @Override
    public Object getItem(int location) {
        return DataList[location];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

      //  if (imageLoader == null)
         //   imageLoader = Controller.getPermission().getImageLoader();
      //  NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.thumbnail);


        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView username = (TextView) convertView.findViewById(R.id.usename);
        TextView emailid = (TextView) convertView.findViewById(R.id.email);
        TextView street = (TextView) convertView.findViewById(R.id.street);
        TextView suite = (TextView) convertView.findViewById(R.id.suite);
        TextView city = (TextView) convertView.findViewById(R.id.city);
        MyPojo m = DataList[position];
      //  thumbNail.setImageUrl(m.getImage(), imageLoader);

        id.setText(m.getId());
        name.setText(m.getName());
        username.setText(m.getUsername());
        emailid.setText(m.getEmail());
        street.setText((CharSequence) m.getAddress().getStreet());
        suite.setText((CharSequence) m.getAddress().getSuite());
        city.setText((CharSequence) m.getAddress().getCity());


       /* name.setText(m.getName());
        source.setText("Wealth Source: " + String.valueOf(m.getSource()));
        worth.setText(String.valueOf(m.getWorth()));
        year.setText(String.valueOf(m.getYear()));*/

        return convertView;
    }
public void notifyData(){
        notifyDataSetChanged();
}
}
