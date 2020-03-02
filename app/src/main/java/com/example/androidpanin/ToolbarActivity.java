package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_start:
                Toast.makeText(this, getText(R.string.go_start).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(StartScreenActivity.class);
                return true;
            case R.id.action_121:
                Toast.makeText(this, getText(R.string.go_121).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_121.class);
                return true;
            case R.id.action_122:
                Toast.makeText(this, getText(R.string.go_122).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_122.class);
                return true;
            case R.id.action_211:
                Toast.makeText(this, getText(R.string.go_211).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_211.class);
                return true;
            case R.id.action_212:
                Toast.makeText(this, getText(R.string.go_212).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_212.class);
                return true;
            case R.id.action_213:
                Toast.makeText(this, getText(R.string.go_213).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_213.class);
                return true;
            case R.id.action_221:
                Toast.makeText(this, getText(R.string.go_221).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_221.class);
                return true;
            case R.id.action_311:
                Toast.makeText(this, getText(R.string.go_311).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_311.class);
                return true;
            case R.id.action_312:
                Toast.makeText(this, getText(R.string.go_312).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_312.class);
                return true;
            case R.id.action_321:
                Toast.makeText(this, getText(R.string.go_321).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_321.class);
                return true;
            case R.id.action_322:
                Toast.makeText(this, getText(R.string.go_322).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_322.class);
                return true;
            case R.id.action_331:
                Toast.makeText(this, getText(R.string.go_331).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_331.class);
                return true;
            case R.id.action_332:
                Toast.makeText(this, getText(R.string.go_332).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_332.class);
                return true;
            case R.id.action_341:
                Toast.makeText(this, getText(R.string.go_341).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_341.class);
                return true;
            case R.id.action_342:
                Toast.makeText(this, getText(R.string.go_342).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_342.class);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle(R.string.start_screen_option_121);
    }

    public void proceedToTask(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
