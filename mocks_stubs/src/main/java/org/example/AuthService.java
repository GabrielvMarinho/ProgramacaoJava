package org.example;

public class AuthService {
    private UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public boolean login(String username, String password){
        User user = userRepository.findUserByUsername(username);
        if(user==null){
            return false;
        }
        return user.getPassword().equals(password);
    }
}
