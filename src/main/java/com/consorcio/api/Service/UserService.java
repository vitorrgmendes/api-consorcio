package com.consorcio.api.Service;

import com.consorcio.api.Model.UserModel;
import com.consorcio.api.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserModel create(UserModel user)
    {
        return userRepository.save(user);
    }

    public List<UserModel> readUsers() throws Exception
    {
        return userRepository.findAll();
    }

    public UserModel readById(Long id) throws Exception
    {
        Optional<UserModel> contaPesquisada = userRepository.findById(id);

        return contaPesquisada.orElseGet(UserModel::new);
    }

    @Transactional
    public UserModel update(UserModel user, Long id) throws Exception
    {
        Optional<UserModel> userExists = userRepository.findById(id);

        if(userExists.isPresent()) {
            UserModel userToUpdate = userExists.get();

            userToUpdate.setName(user.getName());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setPhone(user.getPhone());
            userToUpdate.setAddress(user.getAddress());
            userToUpdate.setComplement(user.getComplement());
            userToUpdate.setState(user.getState());
            userToUpdate.setCity(user.getCity());

            return userRepository.save(userToUpdate);
        } else {
            throw new Exception("User not found with id " + id);
        }
    }


    @Transactional
    public void delete(Long id) throws Exception
    {
        boolean userExist = userRepository.findById(id).isPresent();

        if (userExist)
        {
            userRepository.deleteById(id);
        } else {
            throw new Exception("User not found with id " + id);
        }
    }
}
