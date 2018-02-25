package com.sda.bank;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users;
    private static int idCounter = 0;

    public UserService(){
        this.users = new ArrayList<>();
    }

    public int getNumberOfUsers(){
        return users.size();
    }

    public boolean isUserPresent(int userId){
        return users.stream()
                .anyMatch(e -> userId == e.getId());
    }

    public boolean addUser(User user) {
        boolean result = false;
        if (user != null){
            user.setId(idCounter++);
            users.add(user);
            result = true;
        }
        return result;
    }
}
