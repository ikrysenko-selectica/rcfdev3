package com.selectica.RCFdev3.eclm.definitions;

/**
 * Created by vshilkin on 12/01/2015.
 */
public enum ReminderStatus {
    ACTIVE("active"),
    DISABLED("disabled");

    private String status;

    ReminderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}


