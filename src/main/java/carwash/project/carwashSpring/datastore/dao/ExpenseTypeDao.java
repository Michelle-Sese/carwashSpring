package carwash.project.carwashSpring.datastore.dao;

import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.expenseType.ExpenseType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.TransactionalException;
import java.util.List;


@Repository
public class ExpenseTypeDao implements ExpenseTypeDaoI{

    @PersistenceContext
    private EntityManager em;

    ExpenseType expenseType = new ExpenseType();

    /**
     * List expenseType
     * @return
     * @throws Exception
     */
    public List<ExpenseType> list() throws Exception{
        String hql = "SELECT U FROM ExpenseType U";
        try{
            return this.em.createQuery(hql).getResultList();
        }catch(IllegalArgumentException ex){
            throw new Exception("Invalid query");
        }
        catch(NoResultException ex){
            throw new Exception("No ExpenseType found");
        }
    }

    /**
     * Show expenseType by id
     * @param id
     * @return
     * @throws Exception
     */
    public ExpenseType show(String id) throws Exception {
        return this.findById(id);
    }

    /**
     * save new expenseType
     * @param name
     * @throws Exception
     */
    public void create(String name) throws Exception{
        try {
            this.expenseType.setName(name);

//            Department department = this.em.getReference(Department.class, staffDept);
//            this.staff.setDepartment(department);

            this.em.merge(this.expenseType);
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
     * update expenseType
     * @param name
     * @throws Exception
     */
    public void update(String id, String name) throws Exception{

//        int staffDept = Integer.parseInt(dept);
//        this.staff = this.findById(id);

        try {
            this.expenseType.setName(name);
//            Department department = this.em.getReference(Department.class, staffDept);
//            this.staff.setDepartment(department);

            this.em.merge(this.expenseType);
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
     * Delete expenseType by id
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception{
        try {
            this.expenseType = this.findById(id);
            this.em.remove(this.expenseType);
        }catch(TransactionalException ex){
            throw new Exception("There is no transaction for this entity manager");
        }
    }


    /**
     * Find expenseType by id
     * @param id
     * @return
     * @throws Exception
     */
    private ExpenseType findById(String id) throws Exception{
        if(StringUtils.isBlank(id) || StringUtils.equalsIgnoreCase(id, "0"))
            throw new Exception("Invalid expenseType id");

        try{
            ExpenseType expenseType = this.em.find(ExpenseType.class, Integer.parseInt(id));
            if(expenseType == null)
                throw new Exception("ExpenseType not found");
            else
                return expenseType;

        }catch (IllegalArgumentException ex){
            throw new Exception("Provide a valid expenseType entity or primary key");
        }
    }


}
