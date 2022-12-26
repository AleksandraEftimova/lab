package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.repository.UserRepository;
import mk.ukim.finki.wp.lab.service.UserService;
import mk.ukim.finki.wp.lab.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //zavisnosti
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String password, String name) {
        if (username!=null && password!=null && name!=null){
            User user = new User(username, password, name);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).get();
    }


}
