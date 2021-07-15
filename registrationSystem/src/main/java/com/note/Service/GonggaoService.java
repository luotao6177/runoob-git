package com.note.Service;

import com.note.Model.Gonggao;

import java.util.List;

/**
 * @author lt
 * @create 2020-05-12 23:57
 */
public interface GonggaoService {

    Gonggao selectGonggaoByTitle(String gonggaoTitle);

    int addGonggao(Gonggao gonggao);

    List<Gonggao> getAllGonggao();

    int updategonggaoStatus(Gonggao gonggao);

    Gonggao getGonggaoById(Integer id);
}
