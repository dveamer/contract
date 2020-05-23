package com.dveamer.contract.comment.stub;

import com.dveamer.contract.comment.ConditionDto;

public class ConditionFixture {

    public static ConditionDto conditionDto() {
        ConditionDto condition = new ConditionDto();
        condition.setBeforeDays(2);
        condition.setBiggerThan(3);
        return condition;
    }
}
