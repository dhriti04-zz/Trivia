package com.dhritichawla.trivia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

private List<TestModel> list;
private LayoutInflater mInflater;

class MyViewHolder extends RecyclerView.ViewHolder {
    EasyFlipView flipView;



    MyViewHolder(View view) {
        super(view);
        flipView = (EasyFlipView) view.findViewById(R.id.myEasyFlipView);
    }
}

    MyRecyclerViewAdapter(
            Context context, List<TestModel> list
    ) {
        this.list = list;
        this.mInflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        holder.flipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).isFlipped) {
                    list.get(position).isFlipped = false;
                } else {
                    list.get(position).isFlipped = true;
                }
                holder.flipView.setFlipDuration(700);
                holder.flipView.flipTheView();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}