package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by vince on 7/11/15.
 */
@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "date")
    private Date date;

    @ManyToOne()
    @JoinColumn(name = "user_id", foreignKey = "id")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "article_id", foreignKey = "id")
    private Article article;

}
