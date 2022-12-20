package com.example.linebot.Model;

import com.example.linebot.replier.BjStartReplier;
import com.example.linebot.replier.Replier;
import com.example.linebot.service.CardService;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BJStarter {
    private final BotState botState;
    private CardService cardService;

    public BJStarter(BotState botState, CardService cardService){
        this.botState = botState;
        this.cardService = cardService;
    }

    public Optional<Replier> start(MessageEvent<TextMessageContent> event) {
        String userId = event.getSource().getUserId();
        botState.onBj(userId);

        DeckDraw deckDraw = new DeckDraw(new Deck(), cardService);

        deckDraw.draw("player");
        deckDraw.draw("player");
        deckDraw.draw("dealer");
        deckDraw.draw("dealer");

        if (botState.isBjMode(userId)) {
            Dealer dealer = new Dealer();
            while (true) {
                if (dealer.dSum(cardService.findCard())) {
                    break;
                }else {
                    deckDraw.draw("dealer");
                }
            }
        }


        List<Card> cardsModel = cardService.findCard();
        List<String> plist = new ArrayList<>();
        List<String> dlist = new ArrayList<>();
        for (var card : cardsModel) {
            if (card.getUser().equals("player")) {
                plist.add(card.getMark() + "の" + card.getNumber());
            } else {
                dlist.add(card.getMark() + "の" + card.getNumber());
            }
        }
        return Optional.of(new BjStartReplier(plist, dlist));
    }

}
