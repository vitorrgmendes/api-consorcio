package com.consorcio.api.Service;

import com.consorcio.api.Model.GroupModel;
import com.consorcio.api.Model.UserModel;
import com.consorcio.api.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ResponseEntity<Object> create(UserModel user)
    {
        try
        {
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e)
        {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", 500);
            errorResponse.put("message", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<UserModel> readUsers() throws Exception
    {
        return userRepository.findAll();
    }

    public ResponseEntity<Object> readById(Long id)
    {
        Optional<UserModel> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            // User not found, return error message
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", 404);
            errorResponse.put("message", "User not found!");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        // User found, return the user object
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    public ResponseEntity<Object> getUserGroups(Long userId)
    {
        Optional<UserModel> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            // User not found, return error message
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", 404);
            errorResponse.put("message", "User not found!");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        List<GroupModel> groups = userOptional.get().getGroups();

        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Object> update(UserModel user, Long id)
    {
        try
        {
            // Check if user exists
            Optional<UserModel> userOptional = userRepository.findById(id);
            if (userOptional.isEmpty()) {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("error", 404);
                errorResponse.put("message", "User not found with id " + id);
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }

            // User found, update details
            UserModel userToUpdate = userOptional.get();
            userToUpdate.setName(user.getName());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setPhone(user.getPhone());
            userToUpdate.setAddress(user.getAddress());
            userToUpdate.setComplement(user.getComplement());
            userToUpdate.setState(user.getState());
            userToUpdate.setCity(user.getCity());

            // Save the updated user
            userRepository.save(userToUpdate);

            // Update successful, return the updated user
            return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
        }
        catch (Exception e)
        {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", 500);
            errorResponse.put("message", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Transactional
    public ResponseEntity<Object> delete(Long id)
    {
        try
        {
            Optional<UserModel> userOptional = userRepository.findById(id);

            if (userOptional.isEmpty()) {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("error", 404);
                errorResponse.put("message", "User not found with id " + id);
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
            }

            // Check if user belongs to any groups
            UserModel user = userOptional.get();
            boolean hasGroups = !user.getGroups().isEmpty();

            if (hasGroups)
            {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("error", 409); // Conflict
                errorResponse.put("message", "User cannot be deleted as it belongs to groups!");
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
            }

            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            // Handle exceptions (unchanged)
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", 500);
            errorResponse.put("message", "An error occurred while deleting the user.");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
