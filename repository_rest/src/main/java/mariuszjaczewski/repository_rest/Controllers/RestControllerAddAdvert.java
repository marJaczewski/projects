package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping

public class RestControllerAddAdvert {
    @Autowired
    private final AdvertismentRepository advertismentRepository;


    RestControllerAddAdvert(AdvertismentRepository advertismentRepository){
        this.advertismentRepository = advertismentRepository;
    }

@RequestMapping(value = "/newAdvert", method = RequestMethod.POST)
    public void postAdvert(@RequestBody Advertisment advertisment){
        advertismentRepository.save(advertisment);
System.err.println("dodano");

}




@RequestMapping(value = "/getAllAdverts", method=RequestMethod.GET)
    public List<Advertisment> getAll(){
System.err.println("Wysłano wyszystkie ogloszenia");
       return advertismentRepository.findAll();
}

//    @RequestMapping(value = "/getAllAdverts", method=RequestMethod.GET)
//    public List<String> getAll(){
//List<String> dane=new ArrayList<String>();
//    dane.add("firefoxer");
//        System.err.println("Wysłano");
//        return dane;
//    }
}
