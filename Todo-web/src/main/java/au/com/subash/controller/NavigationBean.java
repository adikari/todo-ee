package au.com.subash.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author subash
 */
@Named(value = "navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {

    private static final String EXT = ".xhtml";
    
    private String page;
    private List<String> lists;

    @PostConstruct
    public void init() {
        page = "start" + EXT; //  Default include.
        lists = new ArrayList();
        lists.add("list1");
        lists.add("list2");
    }
    
    public void addList() {
        lists.add("Untitled");
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page + EXT;
    }
}
