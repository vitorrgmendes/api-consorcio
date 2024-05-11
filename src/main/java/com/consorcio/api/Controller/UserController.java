package com.consorcio.api.Controller;

import com.consorcio.api.Model.UserModel;
import com.consorcio.api.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("signup")
    public void signup(@RequestBody @Valid UserModel user)
    {
        userService.create(user);
    }

    @GetMapping("")
    public List<UserModel> readUsers() throws Exception
    {
        return userService.readUsers();
    }

    @GetMapping("/{id}")
    public UserModel readUserById(@PathVariable("id") Long id) throws Exception
    {
        return userService.readById(id);
    }

    @PutMapping("/{id}/update")
    public UserModel update(@PathVariable("id") Long id, @RequestBody @Valid UserModel user) throws Exception
    {
        return userService.update(user, id);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") Long id) throws Exception
    {
        userService.delete(id);
    }
}
