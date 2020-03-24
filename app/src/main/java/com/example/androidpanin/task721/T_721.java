package com.example.androidpanin.task721;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidpanin.R;
import com.example.androidpanin.ToolbarActivity;
import com.example.androidpanin.Utils;

public class T_721 extends ToolbarActivity {

    private EditText mAddressInput;
    private Button mSearchBtn;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_721);
        initView();
    }

    private void initView() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mAddressInput = findViewById(R.id.addressInput);
        mSearchBtn = findViewById(R.id.searchBtn);

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchAddress();
            }
        });
    }

    public void searchAddress() {
        String address = mAddressInput.getText().toString();

        if(address.equals("")) {
            Toast.makeText(this, getString(R.string.input_empty_msg), Toast.LENGTH_LONG).show();
        } else {
            if (!checkIfCoordinates(address)) {
                uri = Uri.parse("geo:?q=" + address);
            } else {
                uri = Uri.parse("geo:" +  address);
            }

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }
    }

    public boolean checkIfCoordinates(String address) {
        char[] testArr = address.toCharArray();
        for(char c : testArr) {
            if(Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }


}
