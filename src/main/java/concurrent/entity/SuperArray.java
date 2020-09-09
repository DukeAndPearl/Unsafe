package concurrent.entity;

import concurrent.examples.Checker;

public class SuperArray extends Checker {

    private static int BYTE = 8;

    private long size;
    private long address;

    public SuperArray(long size) {
        this.size = size;
        address = unsafe.allocateMemory(size * BYTE);

    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getAddress() {
        return address;
    }

    public void setAddress(long address) {
        this.address = address;
    }

    @Override
    public void check() {
        printer.print("Nothing o check");
    }

}
