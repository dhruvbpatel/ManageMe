package com.example.myapplication1.Adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication1.Activities.MainToDo;

import java.util.List;

import com.example.myapplication1.Model.ToDo;
import com.example.myapplication1.R;

//import in.pateldhruv.todo.MainActivity;
//import in.pateldhruv.todo.Model.ToDo;
//import in.pateldhruv.todo.R;

class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener
{

    ItemClickListner itemClickListner;
    TextView item_title,item_description;

    public ListItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);

        item_title=(TextView)itemView.findViewById(R.id.item_title);
        item_description=(TextView)itemView.findViewById(R.id.item_description);

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

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder>{

    MainToDo mainActivityl;
    List<ToDo> todoList;

    public ListItemAdapter(MainToDo mainActivityl, List<ToDo> todoList) {
        this.mainActivityl = mainActivityl;
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater =LayoutInflater.from(mainActivityl.getBaseContext());
        View view = inflater.inflate(R.layout.list_item,parent,false);

        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder listItemViewHolder, int position) {
        ;

        //set data for item

        listItemViewHolder.item_title.setText(todoList.get(position).getTitle());
        listItemViewHolder.item_description.setText(todoList.get(position).getDescription());

        listItemViewHolder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                //when user select item , data will auto set for  Edit text view
                mainActivityl.title.setText(todoList.get(position).getTitle());
                mainActivityl.description.setText(todoList.get(position).getDescription());

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
