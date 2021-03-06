package me.txb1.database;

import dev.steerup.cacheddatabase.util.Keys;
import dev.steerup.cacheddatabase.util.Result;
import me.txb1.User;

import java.util.List;
import java.util.Optional;

public class Main {

    private static final UserDatabase userDatabase = new UserDatabase();

    public static void main(String[] args) {
        User tobi = new User("Tobi", "Tobi the cool boy", 18, true);
        User noah = new User("Noah", "little brother", 10, true);
        User elias = new User("Elias", "little brother", 9, true);
        User damian = new User("Damian", "Interesting guy", 9, false);
        User lemi = new User("Lemi", "My whole life", 10, true);
        User amin = new User("Amin", "not cool", 18, false);
        User jens = new User("Jens", "JensausNGL", 18, true);
        User justin = new User("Justin", "Justin", 10, true);

        userDatabase.cache(tobi, noah, elias, damian, lemi, amin, jens, justin);

        Keys key = Keys.builder()
                .parameter("dev", true)
                .parameter("age", 18);

        printResult(key);
    }

    private static void printResult(Keys key) {
        List<Result<User>> results = userDatabase.fetchLocalResultList(key);
        results.forEach(userResult -> {
            Optional<User> user = userResult.nullable();
            System.out.println(user.map(Main::formatUser).orElse("null"));
        });
    }

    private static String formatUser(User user) {
        return user.getName() + "(" + user.getDisplayName() + "; " + (user.isDeveloper() ? "developer" : "normal user") + ")";
    }
}