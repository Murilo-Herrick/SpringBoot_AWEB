package br.com.aweb.sistema_manutencao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aweb.sistema_manutencao.model.Manutencao;
import br.com.aweb.sistema_manutencao.service.ManutencaoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/home")
public class ManutencaoController {

    @Autowired
    ManutencaoService manutencaoService;

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("home", Map.of("manutencoes", manutencaoService.findAll()));
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("form", Map.of("manutencao", new Manutencao()));
    }

    @PostMapping("/create")
    public String create(@Valid Manutencao manutencao, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        manutencaoService.createManutencao(manutencao);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editGet(@PathVariable Long id) {
        return new ModelAndView("form", Map.of("manutencao", manutencaoService.findById(id)));
    }

    @PostMapping("/edit/{id}")
    public String editPost(@Valid Manutencao manutencao) {
        manutencaoService.createManutencao(manutencao);
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteGet(@PathVariable Long id) {
        return new ModelAndView("delete", Map.of("manutencao", manutencaoService.findById(id)));
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        manutencaoService.deleteManutencao(id);
        return "redirect:/home";
    }

    @PostMapping("/finish/{id}")
    public String finish(@PathVariable Long id, Manutencao manutencao) {
        manutencaoService.finishManutencao(manutencao, id);
        return "redirect:/home";
    }

}
