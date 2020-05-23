package com.dveamer.contract.comment;

public class ConditionDto {

    private int biggerThan;

    private int beforeDays;
    private int beforeWeeks;

    public ConditionDto() {
    }

    public ConditionDto(int biggerThan, int beforeDays, int beforeWeeks) {
        this.biggerThan = biggerThan;
        this.beforeDays = beforeDays;
        this.beforeWeeks = beforeWeeks;
    }

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

    @Override
    public String toString() {
        return "ConditionDto{" +
                "biggerThan=" + biggerThan +
                ", beforeDays=" + beforeDays +
                ", beforeWeeks=" + beforeWeeks +
                '}';
    }
}
