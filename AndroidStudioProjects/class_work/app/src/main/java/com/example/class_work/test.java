package com.example.class_work;

import java.io.Serializable;

public class test implements Serializable
{
    private String card_num;
    private String cvv_num;
    public test(String card_num, String cvv_num)
    {
        this.card_num = card_num;
        this.cvv_num = cvv_num;
    }
    public String getCard_num()
    {
        return card_num;
    }
    public String getCvv_num()
    {
        return cvv_num;
    }

}
