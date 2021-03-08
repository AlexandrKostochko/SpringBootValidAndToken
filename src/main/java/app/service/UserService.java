package app.service;


import app.exceptions.NotFoundException;
import app.model.Token;
import app.model.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

//    private List<User> usersList = new ArrayList<>();
//
//    public List<User> getAllUsers () {
//        return new ArrayList<>(usersList);
//    }
//
//    public void addUser (User user) {
//        usersList.add(user);
//    }
//
//    public User getUserById (int id) {
//        for (User user : usersList
//             ) {
//            if (user.getId() == (id)) {
//                return user;
//            }
//        }
//        return null;
//    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById (long id) {
        return userRepository.findById(id);
    }

    public User getUserByUserName (String userName) {
        return userRepository.getByUserName(userName);
    }

    public Token auth(User user){
        User byUserName = userRepository.getByUserName(user.getUserName());
        if (user.equals(byUserName)) {
            long id = byUserName.getId();
            Token token = tokenService.getKey(id);
            return token;
        }
        throw new NotFoundException("Incorrect login or password!");
    }
}
