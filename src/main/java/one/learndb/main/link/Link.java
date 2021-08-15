package one.learndb.main.link;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Link {

    @Id
    @SequenceGenerator(
            name = "link_sequence",
            sequenceName = "link_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="link_sequence")
    @Column(updatable = false, nullable = false)
    private Long id;

    // TODO: unique by two fields + userId
    @Column(nullable = false, unique=true)
    private String url;

    @Column(nullable = false)
    private String domain;

    private String subDomain;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    protected Link () {
    }

    public void setUrl(String url) {
        this.url = url;

        // TODO: parse
        this.domain = "domain";
        this.subDomain = "subDomain";
    }

    public String getUrl() {
        return url;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
}
