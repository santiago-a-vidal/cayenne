package org.apache.art.auto;

import org.apache.art.StringET1;
import org.apache.cayenne.CayenneDataObject;

/** 
 * Class _ExtendedTypeEntity was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually, 
 * since it may be overwritten next time code is regenerated. 
 * If you need to make any customizations, please use subclass. 
 */
public abstract class _ExtendedTypeEntity extends CayenneDataObject {

    public static final String NAME_PROPERTY = "name";

    public static final String ID_PK_COLUMN = "ID";

    public void setName(StringET1 name) {
        writeProperty("name", name);
    }
    public StringET1 getName() {
        return (StringET1)readProperty("name");
    }

}