package com.example.androidpanin.task511;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidpanin.R;

import java.util.ArrayList;
import java.util.List;

public class ItemsDataAdapter511 extends BaseAdapter {

    private List<ItemData511> items;
    private LayoutInflater inflater;
    private Context context;

    ItemsDataAdapter511(Context context, List<ItemData511> items) {
        if (items == null) {
            this.items = new ArrayList<>();
        } else {
            this.items = items;
        }
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    void addItem(ItemData511 item) {
        this.items.add(item);
        notifyDataSetChanged();
    }

    void removeItem(int position) {
        items.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ItemData511 getItem(int position) {
        if (position < items.size()) {
            return items.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item_buttons, parent, false);
        }

        final ItemData511 itemData = items.get(position);

        ImageView image = view.findViewById(R.id.itemImage);
        TextView header = view.findViewById(R.id.itemHeader);
        TextView description = view.findViewById(R.id.itemDescription);
        Button okBtn = view.findViewById(R.id.okBtn);
        Button resetBtn = view.findViewById(R.id.resetBtn);

        image.setImageBitmap(itemData.getImage());
        header.setText(itemData.getHeader());
        description.setText(itemData.getDescription());

        final Class<?> cls = itemData.getActivityClass();

        okBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(cls);
                }
            });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });

        return view;
    }

    private void changeActivity(Class cls) {
            Intent intent = new Intent(context, cls);
            context.startActivity(intent);
    }

    public List<ItemData511> getItems() {
        return items;
    }

    public void setItems(List<ItemData511> items) {
        this.items = items;
    }
}
