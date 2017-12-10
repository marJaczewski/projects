package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class TemporaryRestController {

    @Autowired
    private final AdvertismentRepository advertismentRepository;

    public TemporaryRestController(AdvertismentRepository advertismentRepository) {
        this.advertismentRepository = advertismentRepository;
    }

    @RequestMapping(value = "/current/{id}", method = RequestMethod.GET)
    public Advertisment advertismentGET(@PathVariable("id") Long id ){

       return advertismentRepository.findOneById(id);


    }


}
