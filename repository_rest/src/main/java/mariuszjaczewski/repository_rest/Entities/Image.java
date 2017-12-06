package mariuszjaczewski.repository_rest.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    private boolean avatar;

    @NotNull
    private Long advertismentId;
    @NotNull
    @Lob
    private byte[] content;




    public Long getAdvertismentId() {
        return advertismentId;
    }

    public void setAdvertismentId(Long advertismentId) {
        this.advertismentId = advertismentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvatar() {
        return avatar;
    }

    public void setAvatar(boolean avatar) {
        this.avatar = avatar;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
