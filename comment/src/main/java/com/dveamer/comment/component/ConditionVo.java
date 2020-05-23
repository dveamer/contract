package com.dveamer.comment.component;

public class ConditionVo {

    private int biggerThan;
    private int beforeDays;
    private int beforeWeeks;

    public int getBiggerThan() {
        return biggerThan;
    }

    public void setBiggerThan(int biggerThan) {
        this.biggerThan = biggerThan;
    }

    public int getBeforeDays() {
        return beforeDays;
    }

    public void setBeforeDays(int beforeDays) {
        this.beforeDays = beforeDays;
    }

    public int getBeforeWeeks() {
        return beforeWeeks;
    }

    public void setBeforeWeeks(int beforeWeeks) {
        this.beforeWeeks = beforeWeeks;
    }
}
