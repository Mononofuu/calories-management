package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * created by Alekseichenko Sergey <mononofuu@gmail.com>
 */
public class UserUtil {
    public static final List<User> USER_LIST = Arrays.asList(
            new User(1, "user1", "user1@u.com", "pass1", Role.ROLE_USER),
            new User(2, "user2", "user2@u.com", "pass2", Role.ROLE_USER)
    );
}
