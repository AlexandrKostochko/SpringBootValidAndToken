package app.service;

import app.model.Token;
import app.model.User;
import app.model.UserRole;
import app.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserService userService;

    public Token getKey(long userId){
        Optional<Token> byUserId = tokenRepository.findByUserId(userId);
        if(byUserId.isPresent()){
            return byUserId.get();
        }
        UUID uuid = UUID.randomUUID();
        Token token = new Token(userId, uuid.toString());
        return tokenRepository.save(token);
    }

    public boolean isUser(String key){
        Optional<Token> byKey = tokenRepository.getByKey(key);
        return byKey.isPresent();
    }

    public boolean isAdmin(String key){
        Optional<Token> byKey = tokenRepository.getByKey(key);
        if (byKey.isPresent()) {
            Optional<User> byId = userService.getUserById(byKey.get().getId());
            if (byId.isPresent()) {
                if (byId != null && byId.get().getUserRole().equals(UserRole.ADMIN)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
