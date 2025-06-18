package java_core_api.api_java_core.services;

import java_core_api.api_java_core.domain.Tcc;
import java_core_api.api_java_core.mapper.TccMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TccService {

    @Autowired
    private TccMapper tccsMapper;

    public List<Tcc> listarTodos() {
        return tccsMapper.listarTodos();
    }

    public void salvar(Tcc tcc) {
        tccsMapper.salvar(tcc);
    }

    public void atualizar(Tcc tcc) {
        tccsMapper.atualizar(tcc);
    }

    public void deletar(Long id) {
        tccsMapper.deletar(id);
    }

    public Tcc buscarPorId(Long id) {
        return tccsMapper.buscarPorId(id);
    }
}
