package carwash.project.carwashSpring.datastore.dao;


import carwash.project.carwashSpring.datastore.model.expenses.Expenses;
import carwash.project.carwashSpring.datastore.model.services.Services;
import carwash.project.carwashSpring.datastore.model.staff.Staff;

import java.util.List;

public interface ServicesDaoI {
    public List<Services> list()  throws Exception;
    public Services show(String id)  throws Exception;
    public void create(String typeId, String amount)  throws Exception;
    public void update(String typeId,String amount)  throws Exception;
    public void delete(String id)  throws Exception;
}
