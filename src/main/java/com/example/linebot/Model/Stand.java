package com.example.linebot.Model;

public class Stand {
    private int p_hands;
    private int d_hands;

    public Stand(int p_hands, int d_hands){
        this.p_hands = p_hands;
        this.d_hands = d_hands;
    }

    public String battle(){
        if(d_hands > 21 && p_hands > 21){
            return "あなたの負けです！";
        }
        if(d_hands > 21){
            return "あなたの勝ちです！";
        }else if(p_hands > 21) {
            return "あなたの負けです！";
        }else if(p_hands > d_hands){
            return "あなたの勝ちです！";
        }else if(p_hands < d_hands){
            return "あなたの負けです！";
        }
        else {
            return "あなたの負けです！";
        }
    }

    public boolean dHands(){
        if(d_hands < 17){
            return false;
        }
        return true;
    }
}
