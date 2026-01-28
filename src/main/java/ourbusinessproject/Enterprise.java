package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;

    @Size(min=10)
    private String description;

    @NotEmpty
    private String contactName;

    @NotEmpty
    @Email
    private String contactEmail;

    @OneToMany(mappedBy = "enterprise")
    private Collection<Project> projects;

    /**
     * Set the name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the description
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the contactName
     * @param contactName the contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * Set the contactEmail
     * @param contactEmail the contactEmail
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * Return the id
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * return the collection
     * @return collection
     */
    public Collection<Project> getProjects() {
        return projects;
    }

    /**
     * Add a project to the projects collection
     * @param project the project to add
     */
    public void addProjects(Project project){
        if(this.projects==null){
            this.projects = new ArrayList<>();
        }
        this.projects.add(project);
    }
}
