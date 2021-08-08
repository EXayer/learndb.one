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
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String url;

    @Column
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public Link () {
    }
}
