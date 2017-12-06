package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertismentRepository extends JpaRepository<Advertisment, Long> {

    List<Advertisment> findAllByTitle(String Title);
    Advertisment findOneById(Long id);

}
