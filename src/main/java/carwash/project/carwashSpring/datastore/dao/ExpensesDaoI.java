package carwash.project.carwashSpring.datastore.dao;


import carwash.project.carwashSpring.datastore.model.expenses.Expenses;
import carwash.project.carwashSpring.datastore.model.staff.Staff;

import java.util.List;

public interface ExpensesDaoI {
    public List<Expenses> list()  throws Exception;
    public Expenses show(String id)  throws Exception;
    public void create(String typeId, String amount)  throws Exception;
    public void update(String typeId,String amount)  throws Exception;
    public void delete(String id)  throws Exception;
}
