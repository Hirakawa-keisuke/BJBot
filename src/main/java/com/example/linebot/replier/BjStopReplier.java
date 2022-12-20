package com.example.linebot.replier;

import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

import java.util.ArrayList;
import java.util.List;


public class BjStopReplier implements Replier{

    private String result;
    private List<String> plist;
    private List<String> dlist;

    public BjStopReplier(List<String> plist, List<String> dlist, String result){
        this.plist = plist;
        this.dlist = dlist;
        this.result = result;
    }

    public List<String> makeMassage(){
        String pM = "";
        String dM = "";
        List<String> m = new ArrayList<>();
        for(String p: plist){
            pM += "、"+ p;
        }
        for(String d: dlist){
            dM += "、"+ d;
        }
        m.add(pM);
        m.add(dM);
        return m;
    }
    @Override
    public Message reply() {
        List<String> m = makeMassage();
        return new TextMessage("プレイヤー側" + m.get(0) + "\nディーラー側" + m.get(1) + "\n\n " + result);
    }
}

