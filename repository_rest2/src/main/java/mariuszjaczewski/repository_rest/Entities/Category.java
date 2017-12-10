package mariuszjaczewski.repository_rest.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category implements java.io.Serializable{

    private Long id;

    private String name;



private List<Advertisment> advertisments;

    public Category() {    }

    public Category(Long id, String name, List<Advertisment> advertisments) {
        this.id = id;
        this.name = name;
        this.advertisments = advertisments;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
        public List<Advertisment> getAdvertisments(){
        return advertisments;
    }

    public void setAdvertisments(List<Advertisment> advertisments){
        this.advertisments=advertisments;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
