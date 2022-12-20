package com.example.linebot.Model;

import com.example.linebot.Model.Card;
import com.example.linebot.Model.Deck;
import com.example.linebot.service.CardService;


import java.util.Random;

public class DeckDraw {
    private Deck deck;

    private CardService cardService;

    public DeckDraw(Deck deck, CardService cardService){
        this.deck = deck;
        this.cardService = cardService;
    }


    public void draw(String user) {
        Random rand = new Random();
        int randValue = rand.nextInt(deck.amount());
        Card card = deck.drawCard(randValue);
        cardService.registerCard(user, card.getNumber(), card.getMark());
    }

}
