package Basic.Cacher;

import java.io.Serializable;

public class Element implements Serializable{
    private Object key;
    private Object value;
    private volatile int timeToLive = 0;
    private transient long createTime;
    private transient long lastUseTime;
    private transient int useTime = 0;

    public int getUseTime() {
        return useTime;
    }

    public void addUseTime() {
        this.useTime++;
    }

    public long getLastUseTime() {
        return lastUseTime;
    }

    public void setLastUseTime() {
        this.lastUseTime = System.currentTimeMillis();
    }

    public Element(Object key, Object value) {
        this.key = key;
        this.value = value;
        createTime = System.currentTimeMillis();
        lastUseTime = System.currentTimeMillis();
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        addUseTime();
        setLastUseTime();
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    public boolean isExpired(){
        if(timeToLive == 0)
            return false;
        return System.currentTimeMillis() > createTime + timeToLive;
    }
    public long notUseTimeInterval(){
        return System.currentTimeMillis() - lastUseTime;
    }
}
