package com.consorcio.api.Service;

import com.consorcio.api.Model.GroupModel;
import com.consorcio.api.Repository.GroupRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupApplication {
    @Autowired
    private GroupRepository groupRepository;

    @Transactional
    public GroupModel create(GroupModel group) {
        return groupRepository.save(group);
    }

    public List<GroupModel> readGroup() throws Exception{
        return groupRepository.findAll();
    }

    public GroupModel readById(long id) throws Exception {

        Optional<GroupModel> grupoPesquisado = groupRepository.findById(id);
        return grupoPesquisado.orElseGet(GroupModel::new);
    }

    @Transactional
    public GroupModel update(GroupModel group, Long id) throws Exception{
        Optional<GroupModel> groupExists = groupRepository.findById(id);
        if (groupExists.isPresent()) {

            GroupModel groupUpdate = groupExists.get();

            groupUpdate.setName(group.getName());
            groupUpdate.setDataCricao(group.getDataCricao());
            groupUpdate.setMeses(group.getMeses());
            groupUpdate.setDataFinal(group.getDataFinal());
            groupUpdate.setValorParcelas(group.getValorParcelas());
            groupUpdate.setValorTotal(group.getValorTotal());
            groupUpdate.setQuantidadePessoas(group.getQuantidadePessoas());

            return groupRepository.save(groupUpdate);

        }
        else {
            throw new Exception("Group not found");
        }
    }

    @Transactional
    public void delete(long id) throws Exception {

        boolean groupExists = groupRepository.findById(id).isPresent();

        if (groupExists) {
            groupRepository.deleteById(id);
        }
        else {
            throw new Exception("Group not found");
        }
    }
}
