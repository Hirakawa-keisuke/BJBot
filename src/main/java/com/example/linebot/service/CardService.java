package com.example.linebot.service;

import com.example.linebot.Model.Card;
import com.example.linebot.repository.ICardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService implements ICardsService{
    private ICardsRepository iCardsRepository;

    @Autowired
    public CardService(ICardsRepository iCardsRepository){
        this.iCardsRepository = iCardsRepository;
    }

    @Override
    public void registerCard(String user, int number, String mark) {
        int n = iCardsRepository.insert(user, number, mark);
        System.out.println("記録行数：" + n);
    }

    @Override
    public List<Card> findCard() {
        List<Card> cards = iCardsRepository.find();

        return cards;
    }
    @Override
    public void deleteCard(){
        iCardsRepository.delete();
        System.out.println("削除した");
    }

}
