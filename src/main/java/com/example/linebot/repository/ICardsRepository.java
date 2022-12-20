package com.example.linebot.repository;

import com.example.linebot.Model.Card;

import javax.xml.transform.sax.SAXResult;
import java.util.List;

public interface ICardsRepository {
    /**
     * ユーザー名とパスワードをhandsテーブルに記録する
     *
     * @param user ユーザー
     * @param number カードの数字
     * @param mark  カードのマーク
     * @return データベースの更新行数
     */

    public int insert(String user, int number, String mark);

    public int delete();

    public List<Card> find();
}
