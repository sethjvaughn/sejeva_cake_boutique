package com.example.sejevacakeboutique;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sejevacakeboutique.activity.DetailsActivity;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder>  {
    private Context mContext;
    private List<CakeModel> list;

    public SearchAdapter(Context context ,List<CakeModel> list) {
        this.mContext = context;
        this.list=list;

    }

    public void setFilteredList(List<CakeModel> filterlist) {

        this.list = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.search_list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final CakeModel temp = list.get(position);

        holder.tv_name.setText(list.get(position).getName());
        holder.tv_flavor.setText(list.get(position).getFlavor());
        holder.tv_price.setText(list.get(position).getPrice());
        holder.tv_rating.setText(list.get(position).getRating());
        holder.iv_img.setBackgroundResource(list.get(position).getImg());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("img", temp.getImg());
                intent.putExtra("name", temp.getName());
                intent.putExtra("flavor", temp.getFlavor());
                intent.putExtra("rate", temp.getRating());
                intent.putExtra("desc",temp.getDescriptions());
                intent.putExtra("price", temp.getPrice());

                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void filterList(List<CakeModel> filteredList){
        list = filteredList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name, tv_flavor,tv_price,tv_rating;
        ImageView iv_img;
        CardView layout;
        public MyViewHolder(@NonNull View v){
            super(v);
            tv_name = v.findViewById(R.id.tv_name);
            tv_flavor = v.findViewById(R.id.tv_flavor);
            tv_price = v.findViewById(R.id.tv_price);
            tv_rating = v.findViewById(R.id.tv_rating);
            iv_img = v.findViewById(R.id.iv_img);
            layout = v.findViewById(R.id.cardLayout);
        }
    }
}
