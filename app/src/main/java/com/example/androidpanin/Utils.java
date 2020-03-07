package com.example.androidpanin;

import android.app.Activity;
import android.content.Intent;

public class Utils
{
    private static int sTheme;
    private static int sMargins;

    public final static int THEME_BLACK = 0;
    public final static int THEME_BLUE = 1;
    public final static int THEME_GREEN = 2;

    public final static int MATGIN_SMALL = 0;
    public final static int MATGIN_MEDIUM = 1;
    public final static int MATGIN_LARGE = 2;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    public static void changeMargins(Activity activity, int margins)
    {
        sMargins = margins;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_BLACK:
                activity.setTheme(R.style.AppThemeBlack);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.AppThemeBlue);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.AppThemeGreen);
                break;
        }
    }

    public static void onActivityCreateSetMargins(Activity activity)
    {

        switch (sMargins)
        {
            default:
            case MATGIN_SMALL:
                activity.setTheme(R.style.MarginsSmall);
                break;
            case MATGIN_MEDIUM:
                activity.setTheme(R.style.MarginsMedium);
                break;
            case MATGIN_LARGE:
                activity.setTheme(R.style.MarginsLarge);
                break;
        }
    }
}