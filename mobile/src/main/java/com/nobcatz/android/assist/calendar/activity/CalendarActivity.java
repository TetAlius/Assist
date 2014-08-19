package com.nobcatz.android.assist.calendar.activity;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ListView;

import com.nobcatz.android.assist.R;
import com.nobcatz.android.assist.calendar.adapter.CalendarAdapter;
import com.nobcatz.android.assist.calendar.model.Calendar;
import com.nobcatz.android.assist.calendar.util.CalendarsUtility;

import java.util.List;

public class CalendarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        ListView list;
        CalendarAdapter adapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
            addCalendars(rootView, inflater);
            return rootView;
        }

        private void addCalendars(View rootView, LayoutInflater inflater) {
            List<Calendar> calendars = CalendarsUtility.getAllCalendars(getActivity().getApplicationContext());
            list=(ListView)rootView.findViewById(R.id.calendar_list);
            list.setDividerHeight(0);

            adapter=new CalendarAdapter(inflater, calendars);
            list.setAdapter(adapter);

            // Click event for single list row
           // list.setOnItemClickListener(this);
           // list.setOnTouchListener(mTouchListener);
        }
    }
}
