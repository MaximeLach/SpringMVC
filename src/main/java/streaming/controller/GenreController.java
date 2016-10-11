/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import streaming.entity.Genre;
import streaming.service.GenreCrudService;

/**
 *
 * @author admin
 */

@Controller
public class GenreController {
    @Autowired
    private GenreCrudService crud;
    
    @RequestMapping(value="/ajouter_genre",method = RequestMethod.POST)
    public String ajouterPOST(@ModelAttribute("genreAct") Genre genre){
        crud.save(genre);
        return "redirect:/liste_genre";
    }
    
    @RequestMapping(value="/ajouter_genre",method = RequestMethod.GET)
    public String ajouterPOST(Model model){
        Genre genre = new Genre();
        model.addAttribute("genre", genre);
        return "genre_ajouter.jsp";
    }
    
    @RequestMapping(value="/modifier_genre",method = RequestMethod.POST)
    public String editerPOST(@ModelAttribute("genreAct") Genre genre){
        crud.save(genre);
        return "redirect:/liste_genre";
    }
    
    @RequestMapping(value="/modifier_genre/{val}",method = RequestMethod.GET)
    public String editerGET(@PathVariable("val") long idGenreAModifier, Model model){
        Genre genre= crud.findOne(idGenreAModifier);
        model.addAttribute("genreAct",genre);
        return "genre_modifier.jsp";
    }
    
    @RequestMapping(value="/supprimer_genre/{val}", method = RequestMethod.GET)
    public String supprimer(@PathVariable("val") long idGenreASupprimer){
        crud.delete(idGenreASupprimer);
        return "redirect:/liste_genre";
    }
   
    @RequestMapping(value="/liste_genre", method = RequestMethod.GET)
    public String lister(Model m){
        List<Genre> genres = crud.findAllByOrderByNom(); 
        m.addAttribute("genres", genres);
        return "genre_lister.jsp";
    }
}
