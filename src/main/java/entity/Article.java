package entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.sql.Date;
import java.util.List;

/**
 * Created by vince on 7/11/15.
 */
@Getter
@Setter
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
    @JoinColumn(name = "user_id", foreignKey = "id")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "category_id", foreignKey = "id")
    private Category category;

    @XmlTransient
    @OneToMany(mappedBy = "article_id")
    private List<Comment> comments;
}
