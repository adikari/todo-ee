package au.com.subash.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author subash
 */
@Entity
@Table(name = "TODOLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Todolist.findAll", query = "SELECT t FROM Todolist t")
    , @NamedQuery(name = "Todolist.findById", query = "SELECT t FROM Todolist t WHERE t.id = :id")
    , @NamedQuery(name = "Todolist.findByTitle", query = "SELECT t FROM Todolist t WHERE t.title = :title")})
public class Todolist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITLE")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "todolistid")
    private Collection<Todoitem> todoitemCollection;

    public Todolist() {
    }

    public Todolist(Integer id) {
        this.id = id;
    }

    public Todolist(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public Collection<Todoitem> getTodoitemCollection() {
        return todoitemCollection;
    }

    public void setTodoitemCollection(Collection<Todoitem> todoitemCollection) {
        this.todoitemCollection = todoitemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Todolist)) {
            return false;
        }
        Todolist other = (Todolist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "au.com.subash.entity.Todolist[ id=" + id + " ]";
    }

}
