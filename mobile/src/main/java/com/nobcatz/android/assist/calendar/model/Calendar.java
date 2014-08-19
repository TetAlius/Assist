package com.nobcatz.android.assist.calendar.model;

/**
 * Created by marta on 19/08/2014.
 */
public class Calendar {
    private String calendarName;
    private String calendarAccountName;
    private long id;
    private String ownerAccount;

    private String accountType = null;

    public Calendar(long id, String calendarName,String calendarAccountName,String ownerAccount,String accountType){
        this.id = id;
        this.calendarName = calendarName;
        this.calendarAccountName = calendarAccountName;
        this.ownerAccount = ownerAccount;
        this.accountType = accountType;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getCalendarAccountName() {
        return calendarAccountName;
    }

    public void setCalendarAccountName(String calendarAccountName) {
        this.calendarAccountName = calendarAccountName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
