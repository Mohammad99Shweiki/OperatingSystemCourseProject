public class Counter {

    int first;
    int second;

    boolean lock;

    public Counter() {
    }

    public Counter(int first, int second) {
        this.first = first;
        this.second = second;
        lock = false;
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

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public boolean getLock() {
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
        while (lock) ;
        lock = true;
        try {
            first = first + 1;
            second = second - 1;
        } finally {
            lock = false;
        }
    }

    public void secondProcessSynced() {
        while (lock) ;
        lock = true;
        try {
            first = first - 1;
            second = second + 1;
        } finally {
            lock = false;
        }
    }
}
