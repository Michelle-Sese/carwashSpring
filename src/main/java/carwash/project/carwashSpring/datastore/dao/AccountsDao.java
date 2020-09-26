package carwash.project.carwashSpring.datastore.dao;

import carwash.project.carwashSpring.datastore.model.accounts.Accounts;
import org.springframework.stereotype.Repository;
import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.staff.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.TransactionalException;
import java.util.List;
@Repository
public class AccountsDao implements AccountsDaoI{

    @PersistenceContext
    private EntityManager em;

    Accounts accounts = new Accounts();

    /**
     * List Accounts
     * @return
     * @throws Exception
     */
    public List<Accounts> list() throws Exception{
        String hql = "SELECT U FROM Accounts U";
        try{
            return this.em.createQuery(hql).getResultList();
        }catch(IllegalArgumentException ex){
            throw new Exception("Invalid query");
        }
        catch(NoResultException ex){
            throw new Exception("No Accounts found");
        }
    }

    /**
     * Show Accounts by id
     * @param id
     * @return
     * @throws Exception
     */
    public Accounts show(String id) throws Exception {
        return this.findById(id);
    }

    /**
     * save new Accounts
     * @param expenditure
     * @param revenue
     * @throws Exception
     */
    public void create(String expenditure, String revenue) throws Exception{

        try {
            this.accounts.setExpenditure(expenditure);
            this.accounts.setRevenue(revenue);

            this.em.merge(this.accounts);
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
     * update accounts
     * @param expenditure
     * @param revenue
     * @throws Exception
     */
    public void update(String id, String expenditure, String revenue) throws Exception{
        this.accounts = this.findById(id);

        try {
            this.accounts.setExpenditure(expenditure);
            this.accounts.setRevenue(revenue);

            this.em.merge(this.accounts);
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
     * Delete accounts by id
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception{
        try {
            this.accounts = this.findById(id);
            this.em.remove(this.accounts);
        }catch(TransactionalException ex){
            throw new Exception("There is no transaction for this entity manager");
        }
    }


    /**
     * Find accounts by id
     * @param id
     * @return
     * @throws Exception
     */
    private Accounts findById(String id) throws Exception{
        if(StringUtils.isBlank(id) || StringUtils.equalsIgnoreCase(id, "0"))
            throw new Exception("Invalid accounts id");

        try{
            Accounts accounts = this.em.find(Accounts.class, Integer.parseInt(id));
            if(accounts == null)
                throw new Exception("Accounts not found");
            else
                return accounts;

        }catch (IllegalArgumentException ex){
            throw new Exception("Provide a valid Accounts entity or primary key");
        }
    }


}
