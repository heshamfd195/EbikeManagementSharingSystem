package com.company;

public class Member {
    public String Name;
    public String ID;
    public int Balance;
    public int nonActiveDays=0;

    Member previous;
    Member next;

    public Member(String name, String ID , int Balance, int nonActiveDays) {
        this.Name = name;
        this.ID=ID;
        this.Balance = Balance;
        this.nonActiveDays = nonActiveDays;
    }

    @Override
    public String toString() {
        return ID+"[" +
                "Name='" + Name + '\'' +
                ", ID=" + ID +
                ", Bal=" + Balance +
                ", naDays=" + nonActiveDays +
                ']';
    }
}
