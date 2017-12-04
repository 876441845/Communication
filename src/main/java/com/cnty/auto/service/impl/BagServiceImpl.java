package com.cnty.auto.service.impl;

import com.cnty.auto.dao.BagDAO;
import com.cnty.auto.pojo.Bag;
import com.cnty.auto.pojo.Order;
import com.cnty.auto.service.BagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/30 16:42
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Service
public class BagServiceImpl implements BagService {
    @Resource
    private BagDAO bagDAO;

    @Override
    public int saveBag(Bag bag) {
        String id = bag.getBagId();
        // 判断id的存在与否,决定是insert,还是update
        if (id != null && !"".equals(id)) {
            return bagDAO.update(bag);
        }
        bag.setGmtCreate(new Date());
        return bagDAO.insert(bag);
    }

    @Override
    public List<Bag> findBag(Map<String, Object> condition) {
        return bagDAO.select(condition);
    }

    @Override
    public Bag findBagById(String bagId) {
        Map<String, Object> condition = new HashMap<>(16);
        condition.put("bagId", bagId);
        List<Bag> bagList = bagDAO.select(condition);
        return (bagList == null || bagList.size() == 0) ? null : bagList.get(0);
    }

    @Override
    public int deleteBag(String bagId) {
        return bagDAO.delete(bagId);
    }
}
