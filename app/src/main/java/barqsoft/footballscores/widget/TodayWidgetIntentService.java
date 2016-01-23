/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package barqsoft.footballscores.widget;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RemoteViews;

import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;

import barqsoft.footballscores.MainActivity;
import barqsoft.footballscores.R;
import barqsoft.footballscores.Utilies;
import barqsoft.footballscores.DatabaseContract;

import barqsoft.footballscores.widget.TodayWidgetProvider;

/**
 * IntentService which handles updating all Today widgets with the latest data
 */
public class TodayWidgetIntentService extends IntentService {

    private String[] mRealDate = new String[1];

    private static final String[] SCORE_COLUMNS = {
            DatabaseContract.scores_table.MATCH_ID,
            DatabaseContract.scores_table.DATE_COL,
            DatabaseContract.scores_table.TIME_COL,
            DatabaseContract.scores_table.HOME_COL,
            DatabaseContract.scores_table.AWAY_COL,
            DatabaseContract.scores_table.LEAGUE_COL,
            DatabaseContract.scores_table.HOME_GOALS_COL,
            DatabaseContract.scores_table.AWAY_GOALS_COL,
            DatabaseContract.scores_table.MATCH_DAY
    };
    // these indices must match the projection
    private static final int INDEX_MATCH_ID = 0;
    private static final int INDEX_DATE = 1;
    private static final int INDEX_TIME = 2;
    private static final int INDEX_HOME = 3;
    private static final int INDEX_AWAY = 4;
    private static final int INDEX_LEAGUE = 5;
    private static final int INDEX_HOME_GOALS = 6;
    private static final int INDEX_AWAY_GOALS = 7;
    private static final int INDEX_MATCH_DAY = 8;

    public TodayWidgetIntentService() {
        super("TodayWidgetIntentService");

        int today = 0;
        // FInd tomorrow's date
        Date orgfragmentdate = new Date(System.currentTimeMillis()+((today+1)*86400000));
        SimpleDateFormat mformat = new SimpleDateFormat("yyyy-MM-dd");
        setFragmentDate(mformat.format(orgfragmentdate));

    }

    public void setFragmentDate(String date)
    {
        mRealDate[0] = date;
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        // Retrieve all of the Today widget ids: these are the widgets we need to update
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this,
                TodayWidgetProvider.class));

        // Get tomorrow's data from the ContentProvider
        Uri scoreForTomorrowUri = DatabaseContract.scores_table.buildScoreWithDate();
        Cursor data = getContentResolver().query(scoreForTomorrowUri, SCORE_COLUMNS, null, mRealDate, null);
        if (data == null) {
            return;
        }
        if (!data.moveToFirst()) {
            data.close();
            return;
        }

        // Extract the score data from the Cursor
        int scoreId = data.getInt(INDEX_MATCH_ID);
        int scoreArtResourceId = R.drawable.ic_launcher;
        String description = "fuck " + Utilies.getLeague(Integer.parseInt(data.getString(INDEX_LEAGUE)));
        String homeTeam = data.getString(INDEX_HOME);
        String wayTeam = data.getString(INDEX_AWAY);
        data.close();

        // Perform this loop procedure for each Today widget
        for (int appWidgetId : appWidgetIds) {
            // Find the correct layout based on the widget's width
            int widgetWidth = getWidgetWidth(appWidgetManager, appWidgetId);
            int defaultWidth = getResources().getDimensionPixelSize(R.dimen.widget_today_default_width);
            int largeWidth = getResources().getDimensionPixelSize(R.dimen.widget_today_large_width);
            int layoutId;
            if (widgetWidth >= largeWidth) {
                layoutId = R.layout.widget_today_large;
            } else if (widgetWidth >= defaultWidth) {
                layoutId = R.layout.widget_today;
            } else {
                layoutId = R.layout.widget_today_small;
            }
            RemoteViews views = new RemoteViews(getPackageName(), layoutId);

            // Add the data to the RemoteViews
            views.setImageViewResource(R.id.widget_icon, scoreArtResourceId);
            // Content Descriptions for RemoteViews were only added in ICS MR1
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                setRemoteContentDescription(views, description);
            }
            views.setTextViewText(R.id.widget_description, description);
            views.setTextViewText(R.id.widget_high_temperature, homeTeam);
            views.setTextViewText(R.id.widget_low_temperature, wayTeam);

            // Create an Intent to launch MainActivity
            Intent launchIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, launchIntent, 0);
            views.setOnClickPendingIntent(R.id.widget, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    private int getWidgetWidth(AppWidgetManager appWidgetManager, int appWidgetId) {
        // Prior to Jelly Bean, widgets were always their default size
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            return getResources().getDimensionPixelSize(R.dimen.widget_today_default_width);
        }
        // For Jelly Bean and higher devices, widgets can be resized - the current size can be
        // retrieved from the newly added App Widget Options
        return getWidgetWidthFromOptions(appWidgetManager, appWidgetId);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private int getWidgetWidthFromOptions(AppWidgetManager appWidgetManager, int appWidgetId) {
        Bundle options = appWidgetManager.getAppWidgetOptions(appWidgetId);
        if (options.containsKey(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH)) {
            int minWidthDp = options.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
            // The width returned is in dp, but we'll convert it to pixels to match the other widths
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, minWidthDp,
                    displayMetrics);
        }
        return  getResources().getDimensionPixelSize(R.dimen.widget_today_default_width);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    private void setRemoteContentDescription(RemoteViews views, String description) {
        views.setContentDescription(R.id.widget_icon, description);
    }
}
