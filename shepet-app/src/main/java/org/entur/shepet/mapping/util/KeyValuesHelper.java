package org.entur.shepet.mapping.util;

import org.entur.netex2.model.DataManagedObjectStructure;
import org.entur.netex2.model.KeyListStructure;
import org.entur.netex2.model.KeyValueStructure;

import java.util.Optional;

public class KeyValuesHelper {

    public static void SetToKeyValues(DataManagedObjectStructure objectWithKeyValues, String propertyName, String value) {
        if(objectWithKeyValues.getKeyList() == null) {
            objectWithKeyValues.setKeyList(new KeyListStructure());
        }

        Optional<KeyValueStructure> existing = objectWithKeyValues.getKeyList().getKeyValue().stream().filter(kv -> kv.getKey().equals(propertyName)).findFirst();
        // A keyvalue with value == null is not allowed according to the XSD, so we remove it if it exists.
        if(value == null) {
            existing.ifPresent(objectWithKeyValues.getKeyList().getKeyValue()::remove);
            return;
        }
        existing.ifPresentOrElse(keyValueStructure -> keyValueStructure.setValue(value), () -> objectWithKeyValues.getKeyList().getKeyValue().add(new KeyValueStructure().withKey(propertyName).withValue(value)));
    }
}
