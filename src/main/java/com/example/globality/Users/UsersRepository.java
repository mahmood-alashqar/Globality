package com.example.globality.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersModel,Long> {
    UsersModel findUsersModelByUserName(String userName);
}
