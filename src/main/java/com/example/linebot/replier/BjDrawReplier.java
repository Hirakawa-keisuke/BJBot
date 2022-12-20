package com.example.linebot.replier;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class BjDrawReplier implements Replier{
    public String card;

    public BjDrawReplier(String card){
        this.card = card;
    }
    @Override
    public Message reply() {
        return new TextMessage("引いたカードは、" + card);
    }
}
