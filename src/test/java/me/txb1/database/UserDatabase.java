package me.txb1.database;

import dev.steerup.cacheddatabase.AbstractCacheableDatabase;
import dev.steerup.cacheddatabase.util.Keys;
import dev.steerup.cacheddatabase.util.Result;
import me.txb1.User;

public class UserDatabase extends AbstractCacheableDatabase<User> {

    @Override
    public Result<User> load(Keys keys) {
        //Database load logic
        return new Result<>();
    }

    @Override
    public boolean store(User user, Keys keys) {
        //Database store logic
        return true;
    }
}