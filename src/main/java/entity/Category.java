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
@Table(name = "category")
public class Category implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @XmlTransient
    @OneToMany(mappedBy = "category_id")
    private List<Article> articles;
}
