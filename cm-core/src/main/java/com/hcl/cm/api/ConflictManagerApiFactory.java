package com.hcl.cm.api;


public class ConflictManagerApiFactory {
    private static ConflictManagerApiFactory ourInstance = new ConflictManagerApiFactory();

    public static ConflictManagerApiFactory getInstance() {
        return ourInstance;
    }

    private ConflictManagerApiFactory() {
    }

    public ConflictManager createConflictManager() {
        return new DefaultConflictManager();
    }
}
