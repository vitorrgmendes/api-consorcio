package com.consorcio.api.Controller;
import com.consorcio.api.Model.GroupModel;
import com.consorcio.api.Model.SorteioModel;
import com.consorcio.api.Model.UserModel;
import com.consorcio.api.Service.GroupApplication;
import com.consorcio.api.Service.SorteioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("sorteio")

public class SorteioControler {
    @Autowired
    private SorteioService sorteioService;

    @PostMapping("create")
    public void signup(@RequestBody @Valid SorteioModel sorteio)
    {
        sorteioService.create(sorteio);
    }


    @GetMapping("")
    public List<SorteioModel> readGroup() throws Exception{

        return sorteioService.readSorteio();
    }

    @GetMapping("/{id}")
    public SorteioModel readById(@PathVariable("id") Long id) throws Exception{

        return sorteioService.readById(id);
    }

    @PutMapping("/{id}/update")
    public SorteioModel sorteioUpdate (@PathVariable("id") Long id, @RequestBody @Valid SorteioModel sorteio) throws Exception{
        return  sorteioService.update(sorteio, id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteSorteio(@PathVariable("id") Long id) throws Exception{
        sorteioService.delete(id);
    }

}
