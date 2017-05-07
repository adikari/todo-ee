package au.com.subash.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author subash
 */
@Entity
@Table(name = "TODOITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Todoitem.findAll", query = "SELECT t FROM Todoitem t")
    , @NamedQuery(name = "Todoitem.findById", query = "SELECT t FROM Todoitem t WHERE t.id = :id")
    , @NamedQuery(name = "Todoitem.findByTitle", query = "SELECT t FROM Todoitem t WHERE t.title = :title")
    , @NamedQuery(name = "Todoitem.findByIscomplete", query = "SELECT t FROM Todoitem t WHERE t.iscomplete = :iscomplete")})
public class Todoitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISCOMPLETE")
    private Boolean iscomplete;
    @JoinColumn(name = "TODOLISTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Todolist todolistid;

    public Todoitem() {
    }

    public Todoitem(Integer id) {
        this.id = id;
    }

    public Todoitem(Integer id, String title, Boolean iscomplete) {
        this.id = id;
        this.title = title;
        this.iscomplete = iscomplete;
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

    public Boolean getIscomplete() {
        return iscomplete;
    }

    public void setIscomplete(Boolean iscomplete) {
        this.iscomplete = iscomplete;
    }

    public Todolist getTodolistid() {
        return todolistid;
    }

    public void setTodolistid(Todolist todolistid) {
        this.todolistid = todolistid;
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
        if (!(object instanceof Todoitem)) {
            return false;
        }
        Todoitem other = (Todoitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "au.com.subash.entity.Todoitem[ id=" + id + " ]";
    }

}
