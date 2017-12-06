package mariuszjaczewski.repository_rest.Entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
public class Advertisment {

    @Id
    @GeneratedValue
    private Long id;
    private String category;
    @NotNull
    private String title;
    @Lob
    private String description;
    // @NotNull
    // private BigDecimal inclusionDate;

    //  @NotNull
    //  private String userId;


//    public Advertisment(  String category, String title, String description) {
//
//        this.category = category;
//        this.title = title;
//        this.description = description;
//    }

    @Override
    public String toString() {
        return "Advertisment{" +
                "id='" + id + '\'' +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
               // ", inclusionDate=" + inclusionDate +
               // ", userId='" + userId + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;


    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public BigDecimal getInclusionDate() {
//        return inclusionDate;
//    }
//
//    public void setInclusionDate(BigDecimal inclusionDate) {
//        this.inclusionDate = inclusionDate;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
}
