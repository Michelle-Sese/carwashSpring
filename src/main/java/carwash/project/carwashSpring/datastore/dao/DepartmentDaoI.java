package carwash.project.carwashSpring.datastore.dao;

import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.staff.Staff;

import java.util.List;

public interface DepartmentDaoI {
    public List<Department> list()  throws Exception;
    public Department show(String id)  throws Exception;
    public void create(String name)  throws Exception;
    public void update(String id, String name)  throws Exception;
    public void delete(String id)  throws Exception;
}
