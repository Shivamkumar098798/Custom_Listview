package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);

        String []name={"gaana","amazonemusic","spotiyfy","wynkmusic","gaana","amazonemusic","spotiyfy","wynkmusic","gaana","amazonemusic","spotiyfy","wynkmusic","gaana","amazonemusic","spotiyfy","wynkmusic",};
        Integer[]img={R.drawable.gaana,R.drawable.amazonemusic,R.drawable.spotiyfy,R.drawable.wynkmusic,R.drawable.gaana,R.drawable.amazonemusic,R.drawable.spotiyfy,R.drawable.wynkmusic,R.drawable.gaana,R.drawable.amazonemusic,R.drawable.spotiyfy,R.drawable.wynkmusic,R.drawable.gaana,R.drawable.amazonemusic,R.drawable.spotiyfy,R.drawable.wynkmusic,};

        MyListAdapter adapter=new MyListAdapter(this, name,img);
        lv.setAdapter(adapter);

    }
    public class MyListAdapter extends ArrayAdapter<String> {

        private final Activity context;
        private final String[] name;
        private final Integer[] img;

        public MyListAdapter(Activity context, String[] name,Integer[] img) {
            super(context, R.layout.customlist, name);
            // TODO Auto-generated constructor stub

            this.context=context;
            this.img = img;
            this.name=name;
        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.customlist, null,true);

            TextView titleText = (TextView) rowView.findViewById(R.id.title);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

            titleText.setText(name[position]);
            imageView.setImageResource(img[position]);

            return rowView;

        };
    }

}