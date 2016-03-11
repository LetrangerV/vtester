/**
 * @(#)BaseDaoImpl.java 3/11/16.
 * Copyright (c) 2016 The Boeing Company All rights reserved.
 */
package com.letrangerv.vtester.persistence;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    private JdbcTemplate m_jdbcTemplate;

    public BaseDaoImpl(DataSource dataSource) {
        m_jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return m_jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        m_jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int add(T object) {
//        m_jdbcTemplate.update();
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T find(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public T update(T object) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
