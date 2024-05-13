package com.consorcio.api.Controller;

import com.consorcio.api.Model.GroupModel;
import com.consorcio.api.Model.UserModel;
import com.consorcio.api.Service.GroupApplication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("group")

public class GroupController {

    @Autowired
    private GroupApplication groupApplication;

    @PostMapping("create")
    public void signup(@RequestBody @Valid GroupModel group)
    {
        groupApplication.create(group);
    }

    @GetMapping("")
    public List<GroupModel> readGroup() throws Exception{

        return groupApplication.readGroup();
    }

    @GetMapping("/{id}")
    public GroupModel readGroupById(@PathVariable("id") Long id) throws Exception{

        return groupApplication.readById(id);
    }

    @PutMapping("/{id}/update")
    public GroupModel updateGroup(@PathVariable("id") Long id, @RequestBody @Valid GroupModel group) throws Exception{
        return  groupApplication.update(group, id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteGroup(@PathVariable("id") Long id) throws Exception{
        groupApplication.delete(id);
    }
}
