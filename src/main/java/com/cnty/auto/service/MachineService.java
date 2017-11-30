package com.cnty.auto.service;

import com.cnty.auto.pojo.Machine;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/28 11:32
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
public interface MachineService {

    /**
     * 保存机器信息
     *
     * @param machine
     * @return
     */
    int saveMachine(Machine machine);

    /**
     * 根据条件查询Machine
     *
     * @param condition Machine的键值对对象+offset和limit
     * @return
     */
    List<Machine> findMachine(Map<String, Object> condition);

    /**
     * 根据id产讯Machine
     *
     * @param machineId
     * @return
     */
    Machine findMachineById(Integer machineId);

    /**
     * 删除机器信息
     *
     * @param machineId
     * @return
     */
    int deleteMachine(Integer machineId);

}
