package carwash.project.carwashSpring.datastore.dao;

import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.expenseType.ExpenseType;
import carwash.project.carwashSpring.datastore.model.expenses.Expenses;
import carwash.project.carwashSpring.datastore.model.staff.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.TransactionalException;
import java.util.List;

@Repository
public class ExpensesDao implements ExpensesDaoI{

    @PersistenceContext
    private EntityManager em;

    Expenses expenses = new Expenses();

    /**
     * List expenses
     * @return
     * @throws Exception
     */
    public List<Expenses> list() throws Exception{
        String hql = "SELECT U FROM Expenses U";
        try{
            return this.em.createQuery(hql).getResultList();
        }catch(IllegalArgumentException ex){
            throw new Exception("Invalid query");
        }
        catch(NoResultException ex){
            throw new Exception("No Expenses found");
        }
    }

    /**
     * Show expenses by id
     * @param id
     * @return
     * @throws Exception
     */
    public Expenses show(String id) throws Exception {
        return this.findById(id);
    }

    /**
     * save new expenses
     * @param amount
     * @param typeid
     * @throws Exception
     */
    public void create(String typeid, String amount) throws Exception{
        int typeId = Integer.parseInt(typeid);
        double Amount=Double.parseDouble(amount);

        try {
            this.expenses.setAmount(Amount);

            ExpenseType expenseType = this.em.getReference(ExpenseType.class, typeId);
            this.expenses.setExpense(expenseType);

            this.em.merge(this.expenses);
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
     * update expenses
     * @param amount
     * @throws Exception
     */
    public void update(String typeid, String amount) throws Exception{
        int typeId = Integer.parseInt(typeid);
        double Amount=Double.parseDouble(amount);
        try {
            this.expenses.setAmount(Amount);

            ExpenseType expenseType = this.em.getReference(ExpenseType.class, typeId);
            this.expenses.setExpense(expenseType);

            this.em.merge(this.expenses);
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
     * Delete expenses by id
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception{
        try {
            this.expenses = this.findById(id);
            this.em.remove(this.expenses);
        }catch(TransactionalException ex){
            throw new Exception("There is no transaction for this entity manager");
        }
    }


    /**
     * Find expenses by id
     * @param id
     * @return
     * @throws Exception
     */
    private Expenses findById(String id) throws Exception{
        if(StringUtils.isBlank(id) || StringUtils.equalsIgnoreCase(id, "0"))
            throw new Exception("Invalid expenses id");

        try{
            Expenses expenses = this.em.find(Expenses.class, Integer.parseInt(id));
            if(expenses == null)
                throw new Exception("Expenses not found");
            else
                return expenses;

        }catch (IllegalArgumentException ex){
            throw new Exception("Provide a valid expenses entity or primary key");
        }
    }


}
