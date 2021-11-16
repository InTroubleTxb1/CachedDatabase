package me.txb1;

import dev.steerup.cacheddatabase.annotation.Key;

public class User {

    private final String name;
    private final String displayName;
    private final int age;
    private final boolean developer;

    public User(String name, String displayName, int age, boolean developer) {
        this.name = name;
        this.displayName = displayName;
        this.age = age;
        this.developer = developer;
    }

    @Key("name")
    public String getName() {
        return this.name;
    }

    @Key("displayName")
    public String getDisplayName() {
        return this.displayName;
    }

    @Key("age")
    public int getAge() {
        return this.age;
    }

    @Key("dev")
    public boolean isDeveloper() {
        return this.developer;
    }
}