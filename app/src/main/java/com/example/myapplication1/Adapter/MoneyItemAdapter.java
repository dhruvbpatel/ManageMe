package com.example.myapplication1.Adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication1.Activities.MainMoney;
import com.example.myapplication1.Activities.MainToDo;

import java.util.List;

import com.example.myapplication1.Model.MoneyModel;
//import com.example.myapplication1.Model.ToDo;
import com.example.myapplication1.R;

//import in.pateldhruv.todo.MainActivity;
//import in.pateldhruv.todo.Model.ToDo;
//import in.pateldhruv.todo.R;

class MoneyItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener
{

    ItemClickListner itemClickListner;
    TextView item_category,item_money;

    public MoneyItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);

        item_category=(TextView)itemView.findViewById(R.id.item_category);
        item_money=(TextView)itemView.findViewById(R.id.item_money);

    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view,getAdapterPosition(),false);

    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo menuInfo) {

        contextMenu.setHeaderTitle("Select the Action");
        contextMenu.add(0,0,getAdapterPosition(),"DELETE");



    }
}

public class MoneyItemAdapter extends RecyclerView.Adapter<MoneyItemViewHolder>{

    MainMoney mainActivityl;

    List<MoneyModel> todoList;

//    MainMoney mainMoney1;
//    List<ToMoney> Money;

    public MoneyItemAdapter(MainMoney mainActivityl, List<MoneyModel> todoList) {
        this.mainActivityl = mainActivityl;
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public MoneyItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater =LayoutInflater.from(mainActivityl.getBaseContext());
        View view = inflater.inflate(R.layout.money_item,parent,false);

        return new MoneyItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoneyItemViewHolder MoneyItemViewHolder, int position) {
        ;

        //set data for item

        MoneyItemViewHolder.item_category.setText(todoList.get(position).getCategory());
        MoneyItemViewHolder.item_money.setText(todoList.get(position).getMoney());

        MoneyItemViewHolder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                //when user select item , data will auto set for  Edit text view
                mainActivityl.category.setText(todoList.get(position).getCategory());
                mainActivityl.money.setText(todoList.get(position).getMoney());

                mainActivityl.isUpdate=true;
                mainActivityl.idUpdate = todoList.get(position).getId();

            }
        });

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
