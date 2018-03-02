package com.cloud.drore.eboos;

import java.io.Serializable;

/**
 * User: wcy
 * Date: 2017/9/7
 * Time: 10:08
 */
public interface Persistable<ID extends Serializable> extends Serializable {
    ID getId();

    boolean isNew();
}
