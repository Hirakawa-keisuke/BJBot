package com.example.linebot.Model;

import java.util.List;

public class Dealer {

    public boolean dSum(List<Card> cardsModel) {
        int sum = 0;
        for (var card : cardsModel) {
            if (card.getUser().equals("dealer")) {
                sum += card.getNumber();
            }
            if (sum > 17) {
                return true;
            }
        }
        return false;
    }
}
