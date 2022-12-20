package com.example.linebot.Model;

import com.example.linebot.replier.BjStopReplier;
import com.example.linebot.replier.Replier;
import com.example.linebot.service.CardService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BJBattle {
    private final BotState botState;
    private CardService cardService;


    public BJBattle(BotState botState, CardService cardService) {
        this.botState = botState;
        this.cardService = cardService;
    }

    public Optional<Replier> battle(MessageEvent<TextMessageContent> event) {
        String userId = event.getSource().getUserId();
        int psum = 0;
        int dsum = 0;
        String message = event.getMessage().getText();

        if(message.equals("勝負")){
            List<Card> cardsModel = cardService.findCard();
            List<String> plist = new ArrayList<>();
            List<String> dlist = new ArrayList<>();
            for(var card: cardsModel){
                if(card.getUser().equals("player")){
                    psum += card.getNumber();
                    plist.add(card.getMark() + "の" + card.getNumber());
                }else {
                    dsum += card.getNumber();
                    dlist.add(card.getMark() + "の" + card.getNumber());
                }
            }
            Stand stand = new Stand(psum, dsum);
            botState.offBj(userId);
            cardService.deleteCard();
            return Optional.of(new BjStopReplier(plist, dlist, stand.battle()));
        }
        return Optional.empty();
    }

}
