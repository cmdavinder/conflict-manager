package com.hcl.cm.api;


public class ConflictManagerFactory {

    public static ConflictManager createConflictManager() {
        return new DefaultConflictManager();
    }
}
