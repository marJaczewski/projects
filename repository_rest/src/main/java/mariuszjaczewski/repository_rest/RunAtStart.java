package mariuszjaczewski.repository_rest;

import mariuszjaczewski.repository_rest.Controllers.AdvertismentRepository;
import mariuszjaczewski.repository_rest.Entities.Advertisment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class RunAtStart {


    private final AdvertismentRepository advertismentRepository;




    @Autowired
    public RunAtStart(AdvertismentRepository advertismentRepository ) {
        this.advertismentRepository=advertismentRepository;

    }
@PostConstruct
    public void addSeveralAds(){





    Advertisment advertisment1=new Advertisment();
    Advertisment advertisment2=new Advertisment();
    Advertisment advertisment3=new Advertisment();
    Advertisment advertisment4=new Advertisment();
    Advertisment advertisment5=new Advertisment();
    Advertisment advertisment6=new Advertisment();

    advertisment1.setDescription("cordoba, stan bardzo dobry");
    advertisment1.setTitle("seat");
    advertisment1.setCategory("Motoryzacja");

    advertisment2.setDescription("130m^2");
    advertisment2.setTitle("dom");
    advertisment2.setCategory("Nieruchomości");

    advertisment3.setDescription("nad morzem");
    advertisment3.setTitle("dom");
    advertisment3.setCategory("Nieruchomości");

    advertisment4.setDescription("xCover 4, nie porysowany");
    advertisment4.setTitle("samsung");
    advertisment4.setCategory("Elektronika");

    advertisment5.setDescription("czarne, z kieszeniami ,rozmiar L");
    advertisment5.setTitle("spododnie");
    advertisment5.setCategory("Moda");

    advertisment6.setDescription("ibiza, IGŁA");
    advertisment6.setTitle("seat");
    advertisment6.setCategory("Motoryzacja");


    advertismentRepository.save(advertisment1);
    advertismentRepository.save(advertisment2);
    advertismentRepository.save(advertisment3);
    advertismentRepository.save(advertisment4);
    advertismentRepository.save(advertisment5);
    advertismentRepository.save(advertisment6);




    }


}
