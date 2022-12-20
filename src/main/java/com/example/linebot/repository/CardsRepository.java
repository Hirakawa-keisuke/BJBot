package com.example.linebot.repository;

import com.example.linebot.Model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardsRepository implements ICardsRepository{
    private final JdbcTemplate jdbc;

    @Autowired
    public CardsRepository(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }
    @Override
    public int insert(String user, int number, String mark) {
        var sql = "insert into HANDS values (?, ?, ?)";
        var n = jdbc.update(sql, user, number, mark);
        return n;
    }

    @Override
    public int delete(){
        var sql = "delete from hands";
        var n = jdbc.update(sql);
        return n;
    }

    @Override
    public List<Card> find() {
        String sql = "select user, number, mark from hands";

        // 検索用のSQLを実行する方法。
        // 取り出したいデータの型によって、第2引数の RowMapper を切り替える。
        // ? を使うSQLであれば、第3引数の Object型配列 の要素に順番に設定する。
        List<Card> cards = jdbc.query(sql,
                DataClassRowMapper.newInstance(Card.class));

        // 取り出したデータ（Listの要素）をそのまま返値とする。
        return cards;
    }

}
