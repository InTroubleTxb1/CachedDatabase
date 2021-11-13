package me.txb1.database;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {

    private final String name;
    private final String displayName;
    private final int age;
    private final boolean developer;
}