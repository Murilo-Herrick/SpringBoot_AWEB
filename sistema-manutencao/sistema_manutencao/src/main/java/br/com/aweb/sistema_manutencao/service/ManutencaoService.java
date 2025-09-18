package br.com.aweb.sistema_manutencao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.aweb.sistema_manutencao.model.Manutencao;
import br.com.aweb.sistema_manutencao.repository.ManutencaoRepository;

@Service
public class ManutencaoService {
    
    @Autowired
    ManutencaoRepository manutencaoRepository;

    public List<Manutencao> findAll(){
        return manutencaoRepository.findAll(Sort.by("createdAt"));
    }
    
    public Manutencao findById(Long id){
        Optional<Manutencao> manutencao = manutencaoRepository.findById(id);
        if(manutencao.isPresent()){
            return manutencao.get();
        }
        throw new RuntimeException("Solicitação de Manutenção não encontrada!");
    }

    public Manutencao createManutencao(Manutencao manutencao){
        return manutencaoRepository.save(manutencao);
    }

    public void deleteManutencao(Long id){
        if (!manutencaoRepository.existsById(id)){
            throw new RuntimeException("Erro ao exlcuir solicitação de manutenção!");
        }
        manutencaoRepository.deleteById(id);
    }
}
