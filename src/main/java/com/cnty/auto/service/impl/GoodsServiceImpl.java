package com.cnty.auto.service.impl;

import com.cnty.auto.dao.GoodsDAO;
import com.cnty.auto.pojo.Goods;
import com.cnty.auto.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/28 11:34
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDAO goodsDAO;

    @Override
    public int saveGoods(Goods goods) {
        Integer goodsId = goods.getGoodsId();
        if (goodsId != null) {
            return goodsDAO.update(goods);
        }
        return goodsDAO.insert(goods);
    }

    @Override
    public List<Goods> findGoods(Map<String, Object> condition) {
        return goodsDAO.select(condition);
    }

    @Override
    public Goods findGoodsById(Integer goodsId) {
        Map<String, Object> condition = new HashMap<>(16);
        condition.put("goodsId", goodsId);
        List<Goods> goodsList = goodsDAO.select(condition);
        return (goodsList == null || goodsList.size() == 0) ? null : goodsList.get(0);
    }

    @Override
    public int deleteGoods(Integer goodsId) {
        return goodsDAO.delete(goodsId);
    }
}
