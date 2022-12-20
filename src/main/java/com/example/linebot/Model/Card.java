package com.example.linebot.Model;

import java.util.ArrayList;

public class Card {

    private String mark;
    private int number;

    private String user;

    public Card(String mark, int number, String user){
        this.mark = mark;
        this.number = number;
        this.user = user;
    }

    public String getMark(){
        return mark;
    }

    public int getNumber(){
        return number;
    }

    public String getUser(){
        return user;
    }
}
