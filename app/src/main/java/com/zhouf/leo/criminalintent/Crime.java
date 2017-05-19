package com.zhouf.leo.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Leo on 2017-5-3.
 */

public class Crime {
    private UUID mid;
    private String mtitle;
    private Date mDate;
    private boolean mSolved;

    public Crime() {
        mid = UUID.randomUUID();
        mDate = new Date();
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getTitle() {
        return mtitle;
    }

    public void setTitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public UUID getId() {
        return mid;
    }

    @Override
    public String toString() {
        return mtitle;
    }
}
