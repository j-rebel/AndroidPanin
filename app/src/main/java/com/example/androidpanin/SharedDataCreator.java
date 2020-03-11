package com.example.androidpanin;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class SharedDataCreator {

    private static String LARGE_TEXT = "default text";
    private SharedPreferences sp;

    public SharedDataCreator(Context context, String prefName, String resString) {

        this.sp = context.getSharedPreferences(prefName, MODE_PRIVATE);

        if (this.sp.getBoolean("firstRun", true)) {
            alertFirstRun(context);
            SharedPreferences.Editor editor = this.sp.edit();
            editor.putString(LARGE_TEXT, resString).apply();
            editor.putBoolean("firstRun", false).apply();
        }
    }

    public void alertFirstRun(Context context) {
        Toast toast = Toast.makeText(
                context,
                "Первый запуск!",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public SharedPreferences getSp() {
        return sp;
    }

    public static String getPrefText() {
        return LARGE_TEXT;
    }
}
