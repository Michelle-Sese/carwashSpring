package carwash.project.carwashSpring.datastore.dao;

import carwash.project.carwashSpring.datastore.model.accounts.Accounts;
import carwash.project.carwashSpring.datastore.model.staff.Staff;

import java.util.List;

public interface  AccountsDaoI {
    public List<Accounts> list() throws Exception;
    public Accounts show(String id)  throws Exception;
    public void create(String expenditure, String revenue)  throws Exception;
    public void update(String id, String expenditure, String revenue)  throws Exception;
    public void delete(String id)  throws Exception;
}
