package com.example.androidpanin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.androidpanin.task412.T_412;
import com.example.androidpanin.task421.T_421;
import com.example.androidpanin.task422.T_422;
import com.example.androidpanin.task511.T_511;
import com.example.androidpanin.task512.T_512;
import com.example.androidpanin.task521.T_521;
import com.example.androidpanin.task522.T_522;

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
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
            case R.id.action_411:
                Toast.makeText(this, getText(R.string.go_411).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_411.class);
                return true;
            case R.id.action_412:
                Toast.makeText(this, getText(R.string.go_412).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_412.class);
                return true;
            case R.id.action_421:
                Toast.makeText(this, getText(R.string.go_421).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_421.class);
                return true;
            case R.id.action_422:
                Toast.makeText(this, getText(R.string.go_422).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_422.class);
                return true;
            case R.id.action_511:
                Toast.makeText(this, getText(R.string.go_511).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_511.class);
                return true;
            case R.id.action_512:
                Toast.makeText(this, getText(R.string.go_512).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_512.class);
                return true;
            case R.id.action_521:
                Toast.makeText(this, getText(R.string.go_521).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_521.class);
                return true;
            case R.id.action_522:
                Toast.makeText(this, getText(R.string.go_522).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(T_522.class);
                return true;
            case R.id.action_611:
                Toast.makeText(this, getText(R.string.go_611).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(StartScreenActivity.class);
                return true;
            case R.id.action_612:
                Toast.makeText(this, getText(R.string.go_612).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(StartScreenActivity.class);
                return true;
            case R.id.action_711:
                Toast.makeText(this, getText(R.string.go_711).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(StartScreenActivity.class);
                return true;
            case R.id.action_721:
                Toast.makeText(this, getText(R.string.go_721).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(StartScreenActivity.class);
                return true;
            case R.id.action_722:
                Toast.makeText(this, getText(R.string.go_722).toString(), Toast.LENGTH_LONG).show();
                proceedToTask(StartScreenActivity.class);
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
