package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
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
@Table(name = "category")
public class Category implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @XmlTransient
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Article> articles;

    public Collection<Article> getArticles() {
        return new ArrayList<>(articles);
    }
}
