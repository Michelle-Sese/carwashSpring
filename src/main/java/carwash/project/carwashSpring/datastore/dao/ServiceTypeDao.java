package carwash.project.carwashSpring.datastore.dao;

import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.serviceType.ServiceType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.TransactionalException;
import java.util.List;

@Repository
public class ServiceTypeDao implements ServiceTypeDaoI{

    @PersistenceContext
    private EntityManager em;

    ServiceType serviceType = new ServiceType();

    /**
     * List serviceType
     * @return
     * @throws Exception
     */
    public List<ServiceType> list() throws Exception{
        String hql = "SELECT U FROM serviceType U";
        try{
            return this.em.createQuery(hql).getResultList();
        }catch(IllegalArgumentException ex){
            throw new Exception("Invalid query");
        }
        catch(NoResultException ex){
            throw new Exception("No serviceType found");
        }
    }

    /**
     * Show serviceType by id
     * @param id
     * @return
     * @throws Exception
     */
    public ServiceType show(String id) throws Exception {
        return this.findById(id);
    }

    /**
     * save new serviceType
     * @param name
     * @throws Exception
     */
    public void create(String name) throws Exception{
        try {
            this.serviceType.setName(name);

//            Department department = this.em.getReference(Department.class, staffDept);
//            this.staff.setDepartment(department);

            this.em.merge(this.serviceType);
        }catch (EntityExistsException ex){
            throw new Exception(ex.getMessage());
        }catch(IllegalArgumentException ex){
            throw new Exception(ex.getMessage());
        }catch(TransactionalException ex){
            throw new Exception(ex.getMessage());
        }catch (EntityNotFoundException ex){
            throw new Exception(ex.getMessage());
        }
    }

    /**
     * update serviceType
     * @param name
     * @throws Exception
     */
    public void update(String id, String name) throws Exception{

//        int staffDept = Integer.parseInt(dept);
//        this.staff = this.findById(id);

        try {
            this.serviceType.setName(name);
//            Department department = this.em.getReference(Department.class, staffDept);
//            this.staff.setDepartment(department);

            this.em.merge(this.serviceType);
        }catch (EntityExistsException ex){
            throw new Exception(ex.getMessage());
        }catch(IllegalArgumentException ex){
            throw new Exception(ex.getMessage());
        }catch(TransactionalException ex){
            throw new Exception(ex.getMessage());
        }catch (EntityNotFoundException ex){
            throw new Exception(ex.getMessage());
        }
    }


    /**
     * Delete serviceType by id
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception{
        try {
            this.serviceType = this.findById(id);
            this.em.remove(this.serviceType);
        }catch(TransactionalException ex){
            throw new Exception("There is no transaction for this entity manager");
        }
    }


    /**
     * Find serviceType by id
     * @param id
     * @return
     * @throws Exception
     */
    private ServiceType findById(String id) throws Exception{
        if(StringUtils.isBlank(id) || StringUtils.equalsIgnoreCase(id, "0"))
            throw new Exception("Invalid serviceType id");

        try{
            ServiceType serviceType = this.em.find(ServiceType.class, Integer.parseInt(id));
            if(serviceType == null)
                throw new Exception("ServiceType not found");
            else
                return serviceType;

        }catch (IllegalArgumentException ex){
            throw new Exception("Provide a valid serviceType entity or primary key");
        }
    }


}