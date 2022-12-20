package com.example.linebot.Model;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * ユーザーIDをキーとして、ユーザーIDごとに記録するステートフルな情報を管理するデータ管理用のモデル。
 * ユーザーIDごとのモードの記憶とその切り替え、ユーザーIDごとの計算値の記憶とその再計算を担当している。
 * <p>
 * この例では単に、インスタンスの中にデータを記録しているだけだが、
 * 実際には外部ファイルや、Key-Valueデータモデルを用いるデータベース（データ層）等にアクセスする様な事例もある。
 */
@Repository
public class BotState {

    private final Map<String, BotMode> userState;

    public BotState() {

        // ユーザーIDごとのモードを保持
        this.userState = new HashMap<>();
    }

    /**
     * bjモードをON（セッションスコープの開始）
     *
     * @param userId キーとなるユーザーID
     */
    public void onBj(String userId) {
        userState.put(userId, BotMode.Bj);
    }

    /**
     * bjモードをOFF（セッションスコープを破棄）
     *
     * @param userId キーとなるユーザーID
     */
    public void offBj(String userId) {
        userState.remove(userId);
    }

    public void drawBj(String userId){
        userState.put(userId, BotMode.Draw);
    }

    /**
     * bjモードかどうかを調べる
     *
     * @param userId キーとなるユーザーID
     * @return bjモードであれば true, それ以外は false;
     */
    public boolean isBjMode(String userId) {
        BotMode mode = userState.get(userId);
        return mode != null && mode.equals(BotMode.Bj);
    }

}
