package com.consorcio.api.Service;


import com.consorcio.api.Model.BoletosModel;
import com.consorcio.api.Model.GroupModel;
import com.consorcio.api.Repository.BoletosRepository;
import com.consorcio.api.Repository.GroupRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletoService {
    @Autowired
    private BoletosRepository boletosRepository;

    @Transactional
    public BoletosModel create(BoletosModel boletos) {
        return boletosRepository.save(boletos);
    }

    public List<BoletosModel> readGroup() throws Exception {
        return boletosRepository.findAll();
    }

    public BoletosModel readById(long id) throws Exception {
        Optional<BoletosModel> boletoPesquisado = boletosRepository.findById(id);
        return boletoPesquisado.orElseGet(BoletosModel::new);

    }

@Transactional
    public void delete(long id) throws Exception {
        boolean boletoExists = boletosRepository.findById(id).isPresent();

        if(boletoExists) {
            boletosRepository.deleteById(id);

        }else {
            throw new Exception("Boleto não encontrado");
        }

}
}
