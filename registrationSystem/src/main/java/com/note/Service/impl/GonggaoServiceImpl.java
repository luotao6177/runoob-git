package com.note.Service.impl;

import com.note.Dao.GonggaoDao;
import com.note.Model.Gonggao;
import com.note.Service.GonggaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lt
 * @create 2020-05-12 23:58
 */
@Service
public class GonggaoServiceImpl implements GonggaoService {
    @Autowired
    private GonggaoDao gonggaoDao;
    @Override
    public Gonggao selectGonggaoByTitle(String gonggaoTitle) {
        return gonggaoDao.selectGonggaoByTitle(gonggaoTitle);
    }

    @Override
    public int addGonggao(Gonggao gonggao) {
        return gonggaoDao.addGonggao(gonggao);
    }

    @Override
    public List<Gonggao> getAllGonggao() {
        return gonggaoDao.getAllGonggao();
    }

    @Override
    public int updategonggaoStatus(Gonggao gonggao) {
        return gonggaoDao.updategonggaoStatus(gonggao);
    }

    @Override
    public Gonggao getGonggaoById(Integer id) {
        return gonggaoDao.getGonggaoById(id);
    }
}
