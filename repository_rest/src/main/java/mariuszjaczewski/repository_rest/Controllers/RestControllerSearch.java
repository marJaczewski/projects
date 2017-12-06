package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import mariuszjaczewski.repository_rest.Controllers.AdvertismentRepository;

import java.util.List;

@RestController
@RequestMapping
public class RestControllerSearch {

    @Autowired
    private final AdvertismentRepository advertismentRepository;

    private String title;

    public RestControllerSearch(AdvertismentRepository advertismentRepository) {
        this.advertismentRepository=advertismentRepository;

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




}
