package com.example.globality.Infrastructure;

import com.example.globality.Domain.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {
    UsersModel findUsersModelByUserName(String userName);

    UsersModel getUsersModelById(Long id);

}
