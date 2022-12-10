import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    int first;
    int second;

    ReentrantLock lock;

    public Counter() {
    }

    public Counter(int first, int second) {
        this.first = first;
        this.second = second;
        lock = new ReentrantLock();
    }

    public void firstProcessNotSynced() {
        first = first + 1;
        second = second - 1;
    }

    public void secondProcessNotSynced() {
        first = first - 1;
        second = second + 1;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public int getSecond() {
        return second;
    }

    public int getFirst() {
        return first;
    }

    @Override
    public String toString() {
        return "first=" + first +
                "\nsecond=" + second;
    }

    public void firstProcessSynced() {
        while (lock.isLocked()) ;
        lock.lock();
        try {
            first = first + 1;
            second = second - 1;
        } finally {
            lock.unlock();
        }
    }

    public void secondProcessSynced() {
        while (lock.isLocked()) ;
        lock.lock();
        try {
            first = first - 1;
            second = second + 1;
        } finally {
            lock.unlock();
        }
    }
}
