package com.example.medic_complete;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DemoAdapter  extends  RecyclerView.Adapter<DemoVH>{

    List<String> items;
    public  DemoAdapter(List<String> items){
        this.items=items;
    }

    @NonNull
    @Override
    public DemoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);

        return new DemoVH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoVH holder, int position) {
        holder.textView.setText(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
class DemoVH extends RecyclerView.ViewHolder{
    TextView textView;
    private DemoAdapter adapter;

    public DemoVH(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.text) ;
        itemView.findViewById(R.id.delete).setOnClickListener(v -> {
            adapter.items.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());

        });
    }
    public  DemoVH linkAdapter(DemoAdapter adapter){
        this.adapter=adapter;
        return  this;
    }

}