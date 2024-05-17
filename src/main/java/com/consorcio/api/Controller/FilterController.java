package com.consorcio.api.Controller;

import com.consorcio.api.Model.FilterModel;
import com.consorcio.api.Service.FilterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("filter")

public class FilterController {

    @Autowired
    private FilterService filterService;

    @PostMapping("create")
    public void signup(@RequestBody @Valid FilterModel filter)
    {
        filterService.create(filter);
    }


    @GetMapping("")
    public List<FilterModel> readFilter() throws Exception{

        return filterService.readFilter();
    }

    @GetMapping("/{id}")
    public FilterModel readById(@PathVariable("id") Long id) throws Exception{

        return filterService.readById(id);
    }

}