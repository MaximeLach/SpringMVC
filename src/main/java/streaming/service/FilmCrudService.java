/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.entity.Film;
import streaming.spring.SpringConfig;

/**
 *
 * @author tom
 */

public interface FilmCrudService extends CrudRepository<Film, Long>{
    
}
