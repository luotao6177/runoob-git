package com.note.Dao;

import com.note.Model.Gonggao;

import java.util.List;

/**
 * @author lt
 * @create 2020-05-13 0:03
 */
public interface GonggaoDao {
    Gonggao selectGonggaoByTitle(String gonggaoTitle);

    int addGonggao(Gonggao gonggao);

    List<Gonggao> getAllGonggao();

    int updategonggaoStatus(Gonggao gonggao);

    Gonggao getGonggaoById(Integer id);
}
