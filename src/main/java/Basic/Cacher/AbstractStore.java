package Basic.Cacher;

import org.hibernate.event.service.internal.EventListenerServiceInitiator;

import java.util.Map;

public abstract class AbstractStore implements Store{
    protected Map<Object, Element> storeMap;
    public void put(Element element){}

    public Element get(Object key) {
        if(storeMap.containsKey(key))
            return storeMap.get(key);
        else
            return null;
    }

    public void clear() {
        storeMap.clear();
    }

    public boolean remove(Object key) {
        if(storeMap.containsKey(key))
            storeMap.remove(key);
        else
            return false;
        return true;
    }

    public AbstractStore(Map<Object, Element> storeMap) {
        this.storeMap = storeMap;
    }

    public Integer size() {
        return storeMap.size();
    }

}
