package com.cnty.auto.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/27 9:05
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
public interface BaseDAO<T> {
    /**
     * 数据库添加操作
     * @param entity
     * @return 影响的行数
     */
    int insert(T entity);

    /**
     * 数据库删除操作
     * @param id
     * @return 影响的行数
     */
    int delete(Serializable id);

    /**
     * 数据库更新操作
     * @param entity
     * @return 影响的行数
     */
    int update(T entity);

    /**
     * 数据库查询操作
     * @param condition
     * @return 影响的行数
     */
    List<T> select(Map<String,Object> condition);
}
