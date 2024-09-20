package com.receitas.receitas_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.receitas.receitas_api.model.Receitas;

@Service
public class ReceitasService {
    
    private static List<Receitas> receita = new ArrayList<Receitas>();

    public ReceitasService() {
        receitaTeste();
    }

    private void receitaTeste() {
        Receitas receitas = new Receitas();
        receitas.setNome("Bolo de Cenoura");
        String[] lista = {"4 cenouras", "3 ovos", "1 colher oleo", "2 xicaras de F. de trigo", "1 pitada de fermento", "2 xicaras de açucar"};
        receitas.setIngredientes(List.of(lista));
        receitas.setInstrucoes("Em um liquidificador, adicione a cenoura, os ovos e o óleo, depois misture. \nAcrescente o açúcar e bata novamente por 5 minutos. \nEm uma tigela ou na batedeira, adicione a farinha de trigo e depois misture novamente. \ncrescente o fermento e misture lentamente com uma colher. \nAsse em um forno preaquecido a 180° C por aproximadamente 40 minutos.");
        receitas.setId(1L);
        receita.add(receitas);
    // "4 cenouras,\n 3 ovos,\n 1 colher oleo,\n 2 xicaras de F. de trigo,\n 1 pitada de fermento,\n 2 xicaras de açucar"
    }

    public Receitas find(Receitas receitas){
        return receita.stream()
                     .filter(c -> c.equals(receitas))
                     .findFirst().orElse(null);                           
    }

    

    public Receitas find(Long id){
        return find(new Receitas(id));
    }

    public void create(Receitas receitas){
        Long newId = (long) (receita.size() + 1);
        receitas.setId(newId);
        receita.add(receitas);
    }

    public Boolean delete(Long id){
        Receitas _receitas = find(id);
        if (_receitas != null){
            receita.remove(_receitas);
            return true;
        }
        return false;
    }

}