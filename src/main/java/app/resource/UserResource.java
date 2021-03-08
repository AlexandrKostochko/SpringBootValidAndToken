package app.resource;

import app.model.Token;
import app.model.User;
import app.model.UserModel;
import app.service.UserService;
import app.storage.TokenStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenStorage tokenStorage;

    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }

//    @PostMapping(path = "/auth")
//    public ResponseEntity<String> auth(@Valid @RequestBody User user) {
//        if(userService.getAllUsers().contains(user)) {
//            UUID uuid = UUID.randomUUID();
//            String s = uuid.toString();
//            tokenStorage.save(s);
//            return new ResponseEntity<>(s, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping(path = "/auth")
    public ResponseEntity<String> auth(@Valid @RequestBody UserModel userModel){
        User user = new User();
        String userName = userModel.getUserName();
        String password = userModel.getPassword();
        user.setUserName(userName);
        user.setPassword(password);
        User byLogin = userService.getUserByUserName(userName);
        Token token = userService.auth(byLogin);
        return new ResponseEntity<>(token.getKey(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById (@PathVariable(name = "id") long id){
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
