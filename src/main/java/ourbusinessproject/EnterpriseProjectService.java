package ourbusinessproject;

import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EnterpriseProjectService(){}

    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * return the entityManager
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * add to entityManager and return a new Project
     * @param title the title
     * @param description the description
     * @param enterprise the enterprise the project is part of
     * @return the new Project
     */
    public Project newProject(String title, String description, Enterprise enterprise) {
        Project project  = new Project();
        project.setTitle(title);
        project.setDescription(description);
        project.setEnterprise(enterprise);
        entityManager.persist(project);
        entityManager.flush();
        project.getEnterprise().addProjects(project);
        return project;
    }

    /**
     * add to entityManager and return a new Enterprise
     * @param aName the name
     * @param aDescription the description
     * @param aContactName the contact name
     * @param mail the mail
     * @return the new Enterprise
     */
    public Enterprise newEnterprise(String aName, String aDescription, String aContactName, String mail) {
        Enterprise enterprise = new Enterprise();
        enterprise.setName(aName);
        enterprise.setDescription(aDescription);
        enterprise.setContactName(aContactName);
        enterprise.setContactEmail(mail);
        entityManager.persist(enterprise);
        entityManager.flush();
        return enterprise;
    }

    /**
     * Find a Project by its id
     * @param anId the id
     * @return the Project
     */
    public Project findProjectById(Long anId) {
        return entityManager.find(Project.class, anId);
    }

    /**
     * Find an Enterprise by its id
     * @param anId the id
     * @return the Enterprise
     */
    public Enterprise findEnterpriseById(Long anId) {
        return entityManager.find(Enterprise.class, anId);
    }
}
