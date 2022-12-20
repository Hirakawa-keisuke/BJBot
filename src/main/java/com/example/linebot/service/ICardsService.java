package com.example.linebot.service;

import com.example.linebot.Model.Card;

import java.util.List;

public interface ICardsService {
    public void registerCard(String user, int number, String mark);

    public List<Card> findCard();

    public void deleteCard();

}
