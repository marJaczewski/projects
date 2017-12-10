package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertismentRepository extends JpaRepository<Advertisment, Long> {

    List<Advertisment> findAllByTitle(String Title);

    Advertisment findOneById(Long id);
//
//    @Query("select a from Advertisment a where a.id =: id")
//    Advertisment findWithQuery(Long id);

}
