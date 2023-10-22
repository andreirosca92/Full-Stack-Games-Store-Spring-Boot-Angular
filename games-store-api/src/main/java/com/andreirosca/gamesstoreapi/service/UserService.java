package com.andreirosca.gamesstoreapi.service;


import com.andreirosca.gamesstoreapi.model.user_account.UserAccount;
import com.andreirosca.gamesstoreapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    
    
    @Autowired
    private UserRepository repository;


    public UserAccount createUser(UserAccount userAccount) {

        return repository.save(userAccount);
    }

    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    public UserAccount getUser(UUID id) {
        return repository.findById(id).orElseThrow(()-> new IllegalStateException("Not found Game with id = " + id));


    }

    public UserAccount updateUser(UUID id, UserAccount userAccount) {
        UserAccount userAccountFound = repository.findById(id).orElseThrow(()->new IllegalStateException("Not found Game with id = " + id));

        userAccountFound.setCustomer(userAccount.getCustomer());
        userAccountFound.setFirstName(userAccount.getFirstName());
        userAccountFound.setLastName(userAccount.getLastName());
        userAccountFound.setEmail(userAccount.getEmail());
        userAccountFound.setCreationDate(userAccount.getCreationDate());
        userAccountFound.setChangeDate(userAccount.getChangeDate());
        userAccountFound.setRole(userAccount.getRole());
        userAccountFound.setMiddleName(userAccount.getMiddleName());
        userAccountFound.setLockoutDate(userAccount.getLockoutDate());
        userAccountFound.setIsLockedOut(userAccount.isIsLockedOut());
        userAccountFound.setPasswordHash(userAccount.getPasswordHash());
        userAccountFound.setLoginName(userAccount.getLoginName());
        userAccountFound.setIsActive(userAccount.isIsActive());
        return userAccountFound;
    }

    public void deleteAllUsers() {
        repository.deleteAll();
    }

    public void deleteUser(UUID id) {
        repository.deleteById(id);
    }
}
