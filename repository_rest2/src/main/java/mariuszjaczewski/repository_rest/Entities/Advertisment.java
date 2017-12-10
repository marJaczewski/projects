package mariuszjaczewski.repository_rest.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "advertisemet")
public class Advertisment implements java.io.Serializable{


    private Long id;

    @NotNull
    private String title;
    @Lob
    private String description;

    @NotNull
    private Category category;

    public Advertisment() {    }

    public Advertisment(Long id, String title, String description, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", nullable = false)

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
