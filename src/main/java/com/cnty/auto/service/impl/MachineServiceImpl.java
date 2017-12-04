package com.cnty.auto.service.impl;

import com.cnty.auto.dao.MachineDAO;
import com.cnty.auto.pojo.Machine;
import com.cnty.auto.service.MachineService;
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
public class MachineServiceImpl implements MachineService {
    @Resource
    private MachineDAO machineDAO;

    @Override
    public int saveMachine(Machine machine) {
        Integer machineId = machine.getMachineId();
        if (machineId != null) {
            return machineDAO.update(machine);
        }
        return machineDAO.insert(machine);
    }

    @Override
    public List<Machine> findMachine(Map<String, Object> condition) {
        return machineDAO.select(condition);
    }

    @Override
    public Machine findMachineById(Integer machineId) {
        Map<String, Object> condition = new HashMap<>(16);
        condition.put("machineId", machineId);
        List<Machine> machineList = machineDAO.select(condition);
        return (machineList == null || machineList.size() == 0) ? null : machineList.get(0);
    }

    @Override
    public int deleteMachine(Integer machineId) {
        return machineDAO.delete(machineId);
    }
}
