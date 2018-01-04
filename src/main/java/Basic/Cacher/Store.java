package Basic.Cacher;

public interface Store {
    void put(Element element);
    Element get(Object key);
    void clear();
    boolean remove(Object key);
    Integer size();
}
