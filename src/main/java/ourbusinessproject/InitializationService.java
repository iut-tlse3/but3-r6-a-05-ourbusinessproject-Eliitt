package ourbusinessproject;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {

    private Project p1;
    private Project p2;
    private Project p3;
    private Enterprise e1;
    private Enterprise e2;

    @Autowired
    private EnterpriseProjectService eps;

    @Transactional
    public void initProjects() {
        // Comme la méthode est Transactional, si il y a un problème à une étape tout le contenu de la fonction est
        // rollback et donc aucun des trois projet n'est créé.
        e1 = eps.newEnterprise("E1","description entreprise1","agh","fa@gmail.com");
        e2 = eps.newEnterprise("E2","description entreprise2","gag","goah@gmail.com");
        p1 = eps.newProject("proj1","desc",e1);
        p2 = eps.newProject("proj2","desc",e2);
        p3 = eps.newProject("proj3","desc",e1);
    }

    public Project getProject1E1() {
        return p1;
    }

    public Project getProject1E2() {
        return p2;
    }

    public Project getProject2E1() {
        return p3;
    }

    public Enterprise getEnterprise1() {
        return e1;
    }

    public Enterprise getEnterprise2() {
        return e2;
    }
}
