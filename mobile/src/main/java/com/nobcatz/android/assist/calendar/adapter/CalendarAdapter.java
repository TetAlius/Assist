package com.nobcatz.android.assist.calendar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nobcatz.android.assist.R;
import com.nobcatz.android.assist.calendar.model.Calendar;

import java.util.List;

/**
 * Created by marta on 19/08/2014.
 */
public class CalendarAdapter extends BaseAdapter {

    private List<Calendar> calendars;
    private static LayoutInflater inflater=null;

    public CalendarAdapter(LayoutInflater in, List<Calendar> calendars) {
        this.calendars=calendars;
        inflater = in;
    }

    @Override
    public int getCount() {
        return calendars.size();
    }

    @Override
    public Object getItem(int position) {
        return calendars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return calendars.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.calendar_row, null);

        TextView calendarName = (TextView)vi.findViewById(R.id.calendar_name); // Name of calendar
        TextView calendarAccountName = (TextView)vi.findViewById(R.id.calendar_account_name); // Name of the account

        Calendar calendar = calendars.get(position);

        // Setting all values in listview
        calendarName.setText(calendar.getCalendarName());
        calendarAccountName.setText(calendar.getCalendarAccountName());
        //text.bringToFront();

        return vi;
    }
}
