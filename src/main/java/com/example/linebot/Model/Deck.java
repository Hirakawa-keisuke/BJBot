package com.example.linebot.Model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cardList;

    public Deck(){
        String[] marks = new String[]{"ダイヤ", "スペード", "ハート", "クローバー"};
        ArrayList<Card> cardList = new ArrayList<>();
        for (int i = 0; i < marks.length; i++) {
            String mark = marks[i];
            for (int j = 1; j < 14; j++) {
                Card card = new Card(mark, j, "");
                cardList.add(card);
            }
        }
        this.cardList = cardList;
    }

    public void printCardList(){
        for(int i = 0; i < cardList.size(); i++){
            Card card = cardList.get(i);
        }
    }

    public Card drawCard(int n){
        Card draw = cardList.get(n);
        cardList.remove(n);
        Collections.shuffle(cardList);
        return draw;
    }

    public  int amount(){
        return cardList.size();
    }
}
