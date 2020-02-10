package Zjazd3.wszib.model_2;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {


    private Map<Integer, User> userMap = new HashMap<>();

    public User createUser(String imie, String nazwisko, int wiek) {
        int id = new Random().nextInt();
        User user = new User(id, imie, nazwisko, wiek);
        userMap.put(id, user);
        return user;
    }

    public void deleteUser(int id) {
        userMap.remove(id);
    }

    public Collection<User> listUsers() {
        return userMap.values();
    }

    public User getUser(int id) {
        return userMap.get(id);
    }

}
