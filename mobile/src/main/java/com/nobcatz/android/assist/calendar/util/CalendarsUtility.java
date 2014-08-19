package com.nobcatz.android.assist.calendar.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract.Calendars;
import android.util.Log;

import com.nobcatz.android.assist.calendar.model.Calendar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marta on 15/08/2014.
 */
public class CalendarsUtility {

    private static final int PROJECTION_ID_INDEX = 0;
    private static final int PROJECTION_CALENDAR_DISPLAY_NAME_INDEX = 1;
    private static final int PROJECTION_ACCOUNT_NAME_INDEX = 2;
    private static final int PROJECTION_ACCOUNT_TYPE_INDEX = 3;
    private static final int PROJECTION_OWNER_ACCOUNT_INDEX = 4;


    public static final String[] CALENDAR_PROJECTION = new String[]{
            Calendars._ID,
            Calendars.CALENDAR_DISPLAY_NAME,
            Calendars.ACCOUNT_NAME,
            Calendars.ACCOUNT_TYPE,
            Calendars.OWNER_ACCOUNT
    };

    public static List<Calendar> getAllCalendars(Context context) {
        Cursor calCursor = null;
        ContentResolver cr = context.getContentResolver();
        Uri uri = Calendars.CONTENT_URI;
        String selection = "( " + Calendars.VISIBLE + " =? )";
        String[] selectionArgs = new String[]{"1"};

        calCursor = cr.query(uri, CALENDAR_PROJECTION, selection, selectionArgs, Calendars._ID);

        List<Calendar> calendars = new ArrayList<Calendar>();

        if (calCursor.moveToFirst()) {
            long calID = 0;
            String displayName = null;
            String accountName = null;
            String accountType = null;
            String ownerAccount = null;
            do {
                calID = calCursor.getLong(PROJECTION_ID_INDEX);
                displayName = calCursor.getString(PROJECTION_CALENDAR_DISPLAY_NAME_INDEX);
                accountName = calCursor.getString(PROJECTION_ACCOUNT_NAME_INDEX);
                accountType = calCursor.getString(PROJECTION_ACCOUNT_TYPE_INDEX);
                ownerAccount = calCursor.getString(PROJECTION_OWNER_ACCOUNT_INDEX);
                calendars.add(
                        new Calendar(calID,displayName,accountName,ownerAccount,accountType)
                );
                Log.e("calendars", calID + ": " + displayName + " " + accountName + " " + ownerAccount + " " + accountType);
//                EventsUtility.listAllEventsFromCalendar(calID,context);
            } while (calCursor.moveToNext());
        }
        return calendars;
    }
}
