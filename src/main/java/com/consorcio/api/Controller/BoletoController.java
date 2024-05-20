package com.consorcio.api.Controller;

import com.consorcio.api.Model.BoletosModel;
import com.consorcio.api.Model.GroupModel;
import com.consorcio.api.Model.SorteioModel;
import com.consorcio.api.Model.UserModel;
import com.consorcio.api.Service.BoletoService;
import com.consorcio.api.Service.GroupApplication;
import com.consorcio.api.Service.SorteioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoletoController {
    private BoletoService boletoService;

    @PostMapping("create")
    public void signup(@RequestBody @Valid BoletosModel boleto)
    {
        boletoService.create(boleto);
    }


    @GetMapping("")
    public List<BoletosModel> readBoleto() throws Exception{

        return boletoService.readBoleto();
    }

    @GetMapping("/{id}")
    public BoletosModel readById(@PathVariable("id") Long id) throws Exception{

        return boletoService.readById(id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteBoleto(@PathVariable("id") Long id) throws Exception{
        boletoService.delete(id);
    }

}

