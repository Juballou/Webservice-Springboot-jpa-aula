package com.fafram.webservice.services;

import com.fafram.webservice.repositories.UserRepository;
import com.fafram.webservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Userservice {

    @Autowired
    private UserRepository repository; // injeção de dependência

    public List<com.fafram.webservice.entities.User> findAll(){

        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

    public User insert(User user){

        return repository.save(user); //o método save retorna o usuário salvo
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User user){
        User entity = repository.getOne(id);
        updateData(entity,user);
        return repository.save(entity);
    }

    public void updateData(User entity, User user){
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
