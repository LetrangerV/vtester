package com.letrangerv.vtester.persistence;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
@SuppressWarnings("unused")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    private RowMapper<T> rowMapper;

    public final RowMapper<T> getRowMapper() {
        return rowMapper;
    }

    public final void setRowMapper(final RowMapper<T> rowMapper) {
        this.rowMapper = rowMapper;
    }

    @Override
    public final int add(final T object) {
        return 0;
    }

    @Override
    public final T find(final int id) {
        return null;
    }

    @Override
    public final List<T> findAll() {
        return null;
    }

    @Override
    public final T update(final T object) {
        return null;
    }

    @Override
    public final void delete(final int id) {
    }
}
