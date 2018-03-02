package com.cloud.drore.eboos;

import java.io.Serializable;
import java.util.Date;

/**
 * User: wcy
 * Date: 2017/9/6
 * Time: 19:54
 */
public interface Auditable<U, ID extends Serializable> extends Persistable<ID>  {

    U getCreatedBy();

    void setCreatedBy(U var1);

    Date getCreatedDate();

    void setCreatedDate(Date var1);

    U getLastModifiedBy();

    void setLastModifiedBy(U var1);

    Date getLastModifiedDate();

    void setLastModifiedDate(Date var1);
}
