package com.letrangerv.vtester.domain;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
public abstract class Entity {
    private int id;

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }
}
