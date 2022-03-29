package fr.bnn05.tp_opendata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class DiarrhéAdapter extends BaseAdapter {
    Context context;
    ArrayList<Diarrhé> diarrhéArrayList;

    public DiarrhéAdapter(Context context, ArrayList<Diarrhé> diarrhéArrayList) {
        this.context = context;
        this.diarrhéArrayList = diarrhéArrayList;
    }
    @Override
    public int getCount(){
        return diarrhéArrayList.size();
    }

    @Override
    public Object getItem(int i){
        return diarrhéArrayList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ConstraintLayout layoutItem;
        LayoutInflater inf = LayoutInflater.from(context);

        if(view == null){
            layoutItem = (ConstraintLayout) inf.inflate(R.layout.item_layout, viewGroup, false);
        }
        else {
            layoutItem = (ConstraintLayout) view;
        }

        TextView tv = (TextView) layoutItem.findViewById(R.id.textViewDiarrhé);
        tv.setText(diarrhéArrayList.get(i).toString());
        return layoutItem;
    }
}
