package mariuszjaczewski.repository_rest;

import mariuszjaczewski.repository_rest.Controllers.AdvertismentRepository;
import mariuszjaczewski.repository_rest.Controllers.CategoryRepository;
import mariuszjaczewski.repository_rest.Entities.Advertisment;
import mariuszjaczewski.repository_rest.Entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class RunAtStart {


    private final AdvertismentRepository advertismentRepository;
    private final CategoryRepository categoryRepository;


    @Autowired
    public RunAtStart(AdvertismentRepository advertismentRepository, CategoryRepository categoryRepository) {
        this.advertismentRepository = advertismentRepository;
        this.categoryRepository = categoryRepository;}


    //@PostConstruct
    public void addSeveralAds() {
//
//        Advertisment advertisment1 = new Advertisment();
//        Advertisment advertisment2 = new Advertisment();
//        Advertisment advertisment3 = new Advertisment();
//        Advertisment advertisment4 = new Advertisment();
//        Advertisment advertisment5 = new Advertisment();
//        Advertisment advertisment6 = new Advertisment();
//
//        advertisment1.setDescription("cordoba, stan bardzo dobry");
//        advertisment1.setTitle("seat");
//        advertisment1.setCategory("Motoryzacja");
//
//        advertisment2.setDescription("130m^2");
//        advertisment2.setTitle("dom");
//        advertisment2.setCategory("Nieruchomości");
//
//        advertisment3.setDescription("nad morzem");
//        advertisment3.setTitle("dom");
//        advertisment3.setCategory("Nieruchomości");
//
//        advertisment4.setDescription("xCover 4, nie porysowany");
//        advertisment4.setTitle("samsung");
//        advertisment4.setCategory("Elektronika");
//
//        advertisment5.setDescription("czarne, z kieszeniami ,rozmiar L");
//        advertisment5.setTitle("spododnie");
//        advertisment5.setCategory("Moda");
//
//        advertisment6.setDescription("ibiza, IGŁA");
//        advertisment6.setTitle("seat");
//        advertisment6.setCategory("Motoryzacja");
//
//
//        advertismentRepository.save(advertisment1);
//        advertismentRepository.save(advertisment2);
//        advertismentRepository.save(advertisment3);
//        advertismentRepository.save(advertisment4);
//        advertismentRepository.save(advertisment5);
//        advertismentRepository.save(advertisment6);


    }

   // @PostConstruct
    public void addSeverlaCategories() {

        Category cat1 = new Category();
        Category cat2 = new Category();
        Category cat3 = new Category();
        Category cat4 = new Category();
        Category cat5 = new Category();

        cat1.setName("Motoryzacja");
        cat2.setName("Elektronika");
        cat3.setName("Moda");
        cat4.setName("Dom i ogród");
        cat5.setName("Nieruchomości");

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);
        categoryRepository.save(cat4);
        categoryRepository.save(cat5);
    }
}


