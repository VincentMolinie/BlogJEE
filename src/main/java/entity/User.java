package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by vince on 7/11/15.
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    @XmlTransient
    @OneToMany(mappedBy = "user")
    private List<Article> articles;
    @XmlTransient
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
