package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import mariuszjaczewski.repository_rest.Entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import mariuszjaczewski.repository_rest.Controllers.AdvertismentRepository;

import java.util.List;

@RestController
@RequestMapping
public class RestControllerSearch {

    @Autowired
    private final AdvertismentRepository advertismentRepository;
    private final CategoryRepository categoryRepository;


    private String title;

    public RestControllerSearch(AdvertismentRepository advertismentRepository, CategoryRepository categoryRepository) {
        this.advertismentRepository=advertismentRepository;
        this.categoryRepository=categoryRepository;

    }

    @RequestMapping(value = "/titleSearch", method = RequestMethod.POST)
    public void searchPOST(@RequestBody String title ){
        this.title=title;
        System.err.println(this.title);
    }


    @RequestMapping(value = "/getSearched/{title}", method = RequestMethod.GET)
    public List<Advertisment> getSearchedAdvertisments(@PathVariable("title") String title){
        System.err.println("wyslano wyszukane");
       return  advertismentRepository.findAllByTitle(title);
    }


    @RequestMapping(value = "/getAllCategories", method = RequestMethod.GET)
    public List<Category> allCategories(){
        System.err.println("pobrano wszystkie kategorie");

        return categoryRepository.findAll();

    }




}
