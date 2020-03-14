package com.example.androidpanin.task421;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidpanin.R;

import java.util.ArrayList;
import java.util.List;

public class ItemsDataAdapter421 extends BaseAdapter {

    private List<ItemData421> items;
    private LayoutInflater inflater;

    private CompoundButton.OnCheckedChangeListener myCheckChangeList
            = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            items.get((Integer) buttonView.getTag()).setChecked(isChecked);
        }
    };

    ItemsDataAdapter421(Context context, List<ItemData421> items) {
        if (items == null) {
            this.items = new ArrayList<>();
        } else {
            this.items = items;
        }
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    void addItem(ItemData421 item) {
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
    public ItemData421 getItem(int position) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        ItemData421 itemData = items.get(position);

        ImageView image = view.findViewById(R.id.itemImage);
        TextView header = view.findViewById(R.id.itemHeader);
        TextView description = view.findViewById(R.id.itemDescription);
        CheckBox checkBox = view.findViewById(R.id.itemChkBx);

        image.setImageDrawable(itemData.getImage());
        header.setText(itemData.getHeader());
        description.setText(itemData.getDescription());
        checkBox.setOnCheckedChangeListener(myCheckChangeList);
        checkBox.setTag(position);
        checkBox.setChecked(itemData.isChecked());

        return view;
    }
}