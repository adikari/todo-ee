package au.com.subash.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
    , @NamedQuery(name = "Todolist.findByTitle", query = "SELECT t FROM Todolist t WHERE t.title = :title")
    , @NamedQuery(name = "Todolist.findByIdAndUserId", query = "SELECT t FROM Todolist t WHERE t.id = :listId AND t.appuser.id = :userId")
})
public class Todolist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "todolist_id_seq",
                       sequenceName = "todolist_id_seq",
                       allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "todolist_id_seq")
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITLE")
    private String title;
    @JoinColumn(name = "APPUSER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Appuser appuser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "todolistid")
    private List<Todoitem> todoitemList;

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

    public Appuser getAppuser() {
        return appuser;
    }

    public void setAppuser(Appuser appuser) {
        this.appuser = appuser;
    }

    @XmlTransient
    public List<Todoitem> getTodoitemList() {
        return todoitemList;
    }

    public void setTodoitemList(List<Todoitem> todoitemList) {
        this.todoitemList = todoitemList;
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
