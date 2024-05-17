package com.consorcio.api.Service;

import com.consorcio.api.Model.FilterModel;
import com.consorcio.api.Repository.FilterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class FilterService {
    @Autowired
    private FilterRepository filterRepository;

    @Transactional
    public FilterModel create(FilterModel filter) {
        return filterRepository.save(filter);
    }

    public List<FilterModel> readFilter() throws Exception
    {
        return filterRepository.findAll();
    }

    public FilterModel readById(long id) throws Exception {

        Optional<com.consorcio.api.Model.FilterModel> filtorPesquisado = filterRepository.findById(id);
        return filtorPesquisado.orElseGet(FilterModel::new);
    }
}
