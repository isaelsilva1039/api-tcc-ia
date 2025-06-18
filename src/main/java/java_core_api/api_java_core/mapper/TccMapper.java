package java_core_api.api_java_core.mapper;

import java_core_api.api_java_core.domain.Tcc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TccMapper {
    List<Tcc> listarTodos();
    void salvar(Tcc tcc);
    void atualizar(Tcc tcc);
    void deletar(Long id);
    Tcc buscarPorId(Long id);
}
