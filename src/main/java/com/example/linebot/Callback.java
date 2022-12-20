package com.example.linebot;

import com.example.linebot.Model.BJBattle;
import com.example.linebot.Model.BJDraw;
import com.example.linebot.Model.BJStarter;
import com.example.linebot.replier.Follow;
import com.example.linebot.replier.Replier;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.event.MessageEvent;
import com.example.linebot.replier.Parrot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;


@LineMessageHandler
public class Callback {

    private static final Logger log = LoggerFactory.getLogger(Callback.class);
    private final BJStarter bjStarter;
    private final BJDraw bjDraw;
    private final BJBattle bjBattle;

    public Callback(BJStarter bjStarter, BJDraw bjDraw, BJBattle bjBattel){
        this.bjStarter = bjStarter;
        this.bjDraw = bjDraw;
        this.bjBattle = bjBattel;
    }

    // フォローイベントに対応する
    @EventMapping
    public Message handleFollow(FollowEvent event) {
        // 実際はこのタイミングでフォロワーのユーザIDをデータベースにに格納しておくなど
        Follow follow = new Follow(event);
        return follow.reply();
    }

    @EventMapping
    public Message handleMessage(MessageEvent<TextMessageContent> event) {
        String message = event.getMessage().getText();

        Optional<Replier> replier = switch (message) {
            case "開始" -> bjStarter.start(event);
            case "ヒット" -> bjDraw.draw(event);
            default -> bjBattle.battle(event);
        };

        return replier.orElse(new Parrot(event)).reply();
    }

}