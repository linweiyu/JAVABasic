package Basic.Cacher;

import java.util.HashMap;
import java.util.Map;

public class MemoryCache extends AbstractStore{
    private final static Map<Object, Element> mapStore = new HashMap<Object, Element>();
    private int maxSize;

    public MemoryCache(int maxSize){
        super(mapStore);
        this.maxSize = maxSize;
    }

    @Override
    public void put(Element element) {
        if(mapStore.containsKey(element.getKey()))
            mapStore.get(element.getKey()).setValue(element.getValue());
        else{
            if(mapStore.size() >= maxSize){
                if(removeExpiredElement() == 0){
                    removeLastUsedElement();
                }
            }
            mapStore.put(element.getKey(), element);
        }
    }

    @Override
    public boolean remove(Object key) {
        if(mapStore.containsKey(key)){
            mapStore.remove(key);
            return true;
        }
        else
            return false;
    }

    private int removeExpiredElement(){
        int count = 0;
        for(Map.Entry<Object, Element> entry : mapStore.entrySet()){
            if(entry.getValue().isExpired()){
                mapStore.remove(entry.getKey());
                count++;
            }
        }
        return count;
    }

    private void removeLastUsedElement(){
        Object key = null;
        long longestTime = 0;
        for(Map.Entry<Object, Element> entry : mapStore.entrySet()){
            long notUseTime = entry.getValue().notUseTimeInterval();
            if(longestTime <= notUseTime){
                longestTime = notUseTime;
                key = entry.getKey();
            }
        }
        mapStore.remove(key);
    }
}
