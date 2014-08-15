package com.nobcatz.android.assist.calendar.util;


import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract.Events;
import android.text.format.Time;
import android.util.Log;

/**
 * Created by marta on 15/08/2014.
 */
public class EventsUtility {

    private static final int PROJECTION_TITLE = 0;
    private static final int PROJECTION_DTSTART = 1;
    private static final int PROJECTION_DTEND = 2;
    private static final int PROJECTION_EVENT_TIMEZONE = 3;
    private static final int PROJECTION_EVENT_END_TIMEZONE = 4;
    private static final int PROJECTION_DURATION = 5;
    private static final int PROJECTION_ALL_DAY = 6;
    private static final int PROJECTION_RRULE = 7;
    private static final int PROJECTION_RDATE = 8;
    private static final int PROJECTION_CALENDAR_ID = 9;

    private static final String FUTURE_EVENTS_ONLY =
            "((" + Events.DTEND + ">=" + System.currentTimeMillis() + ")OR(" +
                    Events.RRULE + " is not null ))";

    public static final String[] EVENT_PROJECTION = new String[]{
            Events.TITLE,
            Events.DTSTART,
            Events.DTEND,
            Events.EVENT_TIMEZONE,
            Events.EVENT_END_TIMEZONE,
            Events.DURATION,
            Events.ALL_DAY,
            Events.RRULE,
            Events.RDATE,
            Events.CALENDAR_ID
    };

    public static void readAllEventsFromCalendar(Context context) {

        Cursor eventCursor = null;
        ContentResolver cr = context.getContentResolver();
        Uri uri = Events.CONTENT_URI;

        eventCursor = cr.query(uri, EVENT_PROJECTION, FUTURE_EVENTS_ONLY, null, Events.CALENDAR_ID);

        if (eventCursor.moveToFirst()) {
            String title = null;
            String dtstart = null;
            String dtend = null;
            String eventTimezone = null;
            String eventEndTimezone = null;
            String duration = null;
            String allDay = null;
            String rrule = null;
            String rdate = null;
            long calID = 0;

            do {
                title = eventCursor.getString(PROJECTION_TITLE);
                dtstart = eventCursor.getString(PROJECTION_DTSTART);
                dtend = eventCursor.getString(PROJECTION_DTEND);
                eventTimezone = eventCursor.getString(PROJECTION_EVENT_TIMEZONE);
                eventEndTimezone = eventCursor.getString(PROJECTION_EVENT_END_TIMEZONE);
                duration = eventCursor.getString(PROJECTION_DURATION);
                allDay = eventCursor.getString(PROJECTION_ALL_DAY);
                rrule = eventCursor.getString(PROJECTION_RRULE);
                rdate = eventCursor.getString(PROJECTION_RDATE);
                calID = eventCursor.getLong(PROJECTION_CALENDAR_ID);

                if (title != null)
                    Log.e("calendars", calID + " " + title + " " + dtstart + " " + dtend + " " + eventTimezone + " " + eventEndTimezone + " " + duration + " " + allDay + " " + rrule + " " + rdate);
            } while (eventCursor.moveToNext());
        }
    }
}
