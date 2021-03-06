package com.github.yingzhuo.fastdfs.springboot.domain.fdfs;

import java.util.ArrayList;

/**
 * 循环链表类
 */
class CircularList<E> extends ArrayList<E> {

    private int index = -1;

    public void reset() {
        synchronized (this) {
            index = -1;
        }
    }

    public E next() {
        check();

        synchronized (this) {
            index++;
            if (index >= this.size()) {
                index = 0;
            }
            return this.get(index);
        }

    }

    public E current() {
        check();

        synchronized (this) {
            if (index < 0) {
                index = 0;
            }
            return this.get(index);
        }
    }

    public E previous() {
        check();

        synchronized (this) {
            index--;
            if (index < 0) {
                index = this.size() - 1;
            }
            return this.get(index);
        }
    }

    private void check() {
        if (this.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
    }

}
