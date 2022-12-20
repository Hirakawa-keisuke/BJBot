package com.example.linebot.replier;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.util.List;

public class BjStartReplier implements Replier{

    private List<String> plist;
    private List<String> dlist;

    public BjStartReplier(List<String> plist, List<String> dlist){
        this.plist = plist;
        this.dlist = dlist;
    }
    @Override
    public Message reply() {

        return new TextMessage("プレイヤー側:" + plist.get(0) + "、" + plist.get(1) + "\nディーラー側:" + dlist.get(0));
    }

}
