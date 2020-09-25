package carwash.project.carwashSpring.datastore.dao;

import carwash.project.carwashSpring.datastore.model.staff.Staff;

import java.util.List;

public interface StaffDaoI {
    public List<Staff> list()  throws Exception;
    public Staff show(String id)  throws Exception;
    public void create(String fname, String lname, String email, String password, String dept)  throws Exception;
    public void update(String id, String fname, String lname, String email, String password, String dept)  throws Exception;
    public void delete(String id)  throws Exception;
}
