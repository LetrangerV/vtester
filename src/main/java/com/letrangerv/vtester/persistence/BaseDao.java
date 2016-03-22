package com.letrangerv.vtester.persistence;

import java.util.List;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
@SuppressWarnings("unused")
public interface BaseDao<T> {
    int add(T object);
    T find(final int id);
    List<T> findAll();
    T update(T object);
    void delete(final int id);
}
