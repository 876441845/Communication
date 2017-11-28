package com.cnty.auto.service.impl;

import com.cnty.auto.dao.RailDAO;
import com.cnty.auto.pojo.Rail;
import com.cnty.auto.service.RailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/28 11:33
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Service
public class RailServiceImpl implements RailService {
    @Resource
    private RailDAO railDAO;

    @Override
    public int saveRail(Rail rail) {
        Integer railId = rail.getRailId();
        Integer machineId = rail.getMachineId();
        Rail newRail = findRailById(railId,machineId);
        if (newRail != null) {
            return railDAO.update(rail);
        }
        return railDAO.insert(rail);
    }

    @Override
    public List<Rail> findRail(Map<String, Object> condition) {
        return railDAO.select(condition);
    }

    @Override
    public Rail findRailById(Integer railId, Integer machineId) {
        Map<String, Object> condition = new HashMap<>(16);
        condition.put("railId", railId);
        condition.put("machineId", machineId);
        List<Rail> railList = railDAO.select(condition);
        return (railList == null || railList.size() == 0) ? null : railList.get(0);
    }

    @Override
    public int deleteRail(Integer machineId) {
        return railDAO.delete(machineId);
    }
}
