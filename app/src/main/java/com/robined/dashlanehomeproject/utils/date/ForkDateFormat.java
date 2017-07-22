package com.robined.dashlanehomeproject.utils.date;


import android.content.Context;
import android.text.format.DateFormat;
import java.util.Date;
import javax.inject.Inject;

public class ForkDateFormat implements BaseDateFormat {
    private final java.text.DateFormat mDateFormat;

    @Inject ForkDateFormat(Context context) {
        mDateFormat = DateFormat.getMediumDateFormat(context);
    }

    @Override
    public String getReadableDate(Date date) {
        return mDateFormat.format(date);
    }
}
