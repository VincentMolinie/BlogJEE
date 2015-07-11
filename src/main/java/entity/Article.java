package entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by vince on 7/11/15.
 */
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="article")
public class Article implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "date")
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @XmlTransient
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Comment> comments;

    public Collection<Comment> getComments() {
        return new ArrayList<>(comments);
    }
}
