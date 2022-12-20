package com.example.linebot.Model;

import com.example.linebot.replier.BjDrawReplier;
import com.example.linebot.replier.Replier;
import com.example.linebot.service.CardService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BJDraw {
    private final BotState botState;
    private CardService cardService;

    public BJDraw(BotState botState, CardService cardService){

        this.botState = botState;
        this.cardService = cardService;
    }

    public Optional<Replier> draw(MessageEvent<TextMessageContent> event) {
        String userId = event.getSource().getUserId();
        botState.onBj(userId);
        DeckDraw deckDraw = new DeckDraw(new Deck(), cardService);
        deckDraw.draw("player");

        List<Card> cardsModel = cardService.findCard();
        var drawNum = cardsModel.get(cardsModel.size() -1).getNumber();
        var drawMark = cardsModel.get(cardsModel.size() -1).getMark();
        return  Optional.of(new BjDrawReplier(drawMark + "の" + drawNum));
    }
}
