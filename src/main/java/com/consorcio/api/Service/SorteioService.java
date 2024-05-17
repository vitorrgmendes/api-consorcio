package com.consorcio.api.Service;

import com.consorcio.api.Model.SorteioModel;
import com.consorcio.api.Repository.GroupRepository;
import com.consorcio.api.Repository.SorteioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SorteioService {
    @Autowired
    private SorteioRepository sorteioRepository;

    @Transactional
    public SorteioModel create(SorteioModel sorteio) {
        return sorteioRepository.save(sorteio);
    }

    public List<SorteioModel> readSorteio() throws Exception{
        return sorteioRepository.findAll();
    }

    public SorteioModel readById(long id) throws Exception {

        Optional<SorteioModel> sorteioPesquisado = sorteioRepository.findById(id);
        return sorteioPesquisado.orElseGet(SorteioModel::new);

    }

    @Transactional
    public SorteioModel update(SorteioModel sorteio, Long id) throws Exception{
        Optional<SorteioModel> SorteioExists = sorteioRepository.findById(id);

        if(SorteioExists.isPresent()) {
            SorteioModel sorteioUpdate = SorteioExists.get();

            sorteioUpdate.setData(sorteioUpdate.getData());

            return sorteioRepository.save(sorteioUpdate);

        } else {
        throw  new Exception("Sorteio não encontrado!");
    }


}

    @Transactional
    public void delete(long id) throws Exception {

        boolean SorteioExists = sorteioRepository.findById(id).isPresent();

        if (SorteioExists) {
            sorteioRepository.deleteById(id);
        }
        else {
            throw new Exception("Group not found");
        }
    }
}