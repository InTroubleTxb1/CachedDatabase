package me.txb1.database;

import dev.steerup.cacheddatabase.util.Keys;
import dev.steerup.cacheddatabase.util.Result;

import java.util.Arrays;
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

        cache(tobi, noah, elias, damian, lemi, amin, jens, justin);

        Keys key = Keys.builder()
                .parameter("age", "18");

        printResult(key);
    }

    private static void printResult(Keys key) {
        long l = System.currentTimeMillis();
        List<Result<User>> results = userDatabase.fetchLocalResultList(key);
        System.out.println("took " + (System.currentTimeMillis() - l));
        results.forEach(userResult -> {
            Optional<User> user = userResult.nullable();
            System.out.println(user.map(Main::formatUser).orElse("null"));
        });
    }

    private static String formatUser(User user) {
        return user.getName() + "(" + user.getDisplayName() + "; " + (user.isDeveloper() ? "developer" : "normal user") + ")";
    }

    private static void cache(User... user) {
        Arrays.stream(user).forEach(stream -> userDatabase.cache(
                stream,
                Keys.builder()
                        .parameter("name", stream.getName())
                        .parameter("displayName", stream.getDisplayName())
                        .parameter("age", String.valueOf(stream.getAge()))
                        .parameter("developer", String.valueOf(stream.isDeveloper()))
        ));
    }
}