package com.example.class_word_2;

import android.widget.EditText;

import java.io.Serializable;

public class data_next implements Serializable {
    private String data_main;


    public data_next(String data_main)
    {
        this.data_main = data_main;
    }

    public String getData_main()
    {
        return data_main;
    }
//-------------------------------------------------------------


    private String time;
    private String day;
    private String comment;

    public data_next (String time, String day, String comment)
    {
        this.time = time;
        this.day = day;
        this.comment = comment;
    }
    public String getTime()
    {
        return time;
    }
    public String getDay()
    {
        return day;
    }
    public String getComment()
    {
        return comment;
    }
}
