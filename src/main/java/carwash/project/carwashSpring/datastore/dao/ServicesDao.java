package carwash.project.carwashSpring.datastore.dao;

import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.expenseType.ExpenseType;
import carwash.project.carwashSpring.datastore.model.expenses.Expenses;
import carwash.project.carwashSpring.datastore.model.serviceType.ServiceType;
import carwash.project.carwashSpring.datastore.model.services.Services;
import carwash.project.carwashSpring.datastore.model.staff.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.TransactionalException;
import java.util.List;

@Repository
public class ServicesDao implements ServicesDaoI {

    @PersistenceContext
    private EntityManager em;

    Services services = new Services();

    /**
     * List services
     * @return
     * @throws Exception
     */
    public List<Services> list() throws Exception{
        String hql = "SELECT U FROM Services U";
        try{
            return this.em.createQuery(hql).getResultList();
        }catch(IllegalArgumentException ex){
            throw new Exception("Invalid query");
        }
        catch(NoResultException ex){
            throw new Exception("No Services found");
        }
    }

    /**
     * Show Services by id
     * @param id
     * @return
     * @throws Exception
     */
    public Services show(String id) throws Exception {
        return this.findById(id);
    }

    /**
     * save new Services
     * @param amount
     * @param typeid
     * @throws Exception
     */
    public void create(String typeid, String amount) throws Exception{
        int typeId = Integer.parseInt(typeid);
        double Amount=Double.parseDouble(amount);

        try {
            this.services.setAmount(Amount);

            ServiceType serviceType = this.em.getReference(ServiceType.class, typeId);
            this.services.setService(serviceType);

            this.em.merge(this.services);
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
     * update Services
     * @param amount
     * @throws Exception
     */
    public void update(String typeid, String amount) throws Exception{
        int typeId = Integer.parseInt(typeid);
        double Amount=Double.parseDouble(amount);
        try {
            this.services.setAmount(Amount);

            ServiceType serviceType = this.em.getReference(ServiceType.class, typeId);
            this.services.setService(serviceType);

            this.em.merge(this.services);
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
     * Delete services by id
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception{
        try {
            this.services = this.findById(id);
            this.em.remove(this.services);
        }catch(TransactionalException ex){
            throw new Exception("There is no transaction for this entity manager");
        }
    }


    /**
     * Find services by id
     * @param id
     * @return
     * @throws Exception
     */
    private Services findById(String id) throws Exception{
        if(StringUtils.isBlank(id) || StringUtils.equalsIgnoreCase(id, "0"))
            throw new Exception("Invalid services id");

        try{
            Services services = this.em.find(Services.class, Integer.parseInt(id));
            if(services == null)
                throw new Exception("Services not found");
            else
                return services;

        }catch (IllegalArgumentException ex){
            throw new Exception("Provide a valid services entity or primary key");
        }
    }


}
