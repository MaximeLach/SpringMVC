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
import streaming.entity.Film;
import streaming.service.FilmCrudService;
import streaming.service.GenreCrudService;

/**
 *
 * @author tom
 */
@Controller
public class FilmController {
    @Autowired
    private FilmCrudService crud;
    @Autowired
    private GenreCrudService crudGenre;
    
    @RequestMapping(value="/lister_films", method = RequestMethod.GET)
    public String listerGET(Model model){
        List<Film> films = crud.findAllByOrderByTitre();
        model.addAttribute("films",films);
        return "film_lister.jsp";
    }
    
    @RequestMapping(value="/supprimer_film/{idFilm}", method = RequestMethod.GET)
    public String supprimerFilm(@PathVariable("idFilm") long idFilm){
        crud.delete(idFilm);
        return "redirect:/lister_films";
    }
    
    @RequestMapping(value = "/editer_film/{idFilm}",method = RequestMethod.GET)
    public String editerFilmGET(@PathVariable("idFilm") long idFilm, Model model){
        Film film = crud.findOne(idFilm);
        model.addAttribute("film",film);
        model.addAttribute("genres", crudGenre.findAllByOrderByNom());
        return "film_editer.jsp";
    }
    
    @RequestMapping (value="/editer_film", method = RequestMethod.POST)
    public String editerFilmPOST(@ModelAttribute("film") Film film){
        crud.save(film);
        return "redirect:/lister_films";
    }
    
    @RequestMapping(value="/ajouter_film",method = RequestMethod.POST)
    public String ajouterPOST(@ModelAttribute("film") Film film){
        crud.save(film);
        return "redirect:/lister_films";
    }
    
    @RequestMapping(value="/ajouter_film",method = RequestMethod.GET)
    public String ajouterPOST(Model model){
        model.addAttribute("film", new Film());
        model.addAttribute("genres", crudGenre.findAllByOrderByNom());
        return "film_ajouter.jsp";
    }
}
