package com.example.globality.Infrastructure;

import com.example.globality.Users.UsersModel;
import com.example.globality.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImplementation implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;

    public UsersModel updateUser(Long id, UsersModel request) {
        UsersModel fromDb = usersRepository.getUsersModelById(id);
        fromDb.setUserName(request.getUsername());
        fromDb.setEmail(request.getEmail());
        fromDb.setPhoneNumber(request.getPhoneNumber());

        return usersRepository.save(fromDb);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersModel usersModel = usersRepository.findUsersModelByUserName(username);

        if (usersModel == null) {

            System.out.print("Username not found");
            throw new UsernameNotFoundException((username + " not found"));
        }
        return new User(usersModel.getUsername(), usersModel.getPassword(), usersModel.isEnabled(), true, true, true, usersModel.getAuthorities());
    }
}
