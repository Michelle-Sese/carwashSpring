package carwash.project.carwashSpring.datastore.dao;

import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.staff.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.TransactionalException;
import java.util.List;

@Repository
public class DepartmentDao implements DepartmentDaoI{

    @PersistenceContext
    private EntityManager em;

    Department department = new Department();

    /**
     * List department
     * @return
     * @throws Exception
     */
    public List<Department> list() throws Exception{
        String hql = "SELECT U FROM Department U";
        try{
            return this.em.createQuery(hql).getResultList();
        }catch(IllegalArgumentException ex){
            throw new Exception("Invalid query");
        }
        catch(NoResultException ex){
            throw new Exception("No Department found");
        }
    }

    /**
     * Show department by id
     * @param id
     * @return
     * @throws Exception
     */
    public Department show(String id) throws Exception {
        return this.findById(id);
    }

    /**
     * save new staff
     * @param name
     * @throws Exception
     */
    public void create(String name) throws Exception{
        try {
            this.department.setName(name);

//            Department department = this.em.getReference(Department.class, staffDept);
//            this.staff.setDepartment(department);

            this.em.merge(this.department);
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
     * update department
     * @param name
     * @throws Exception
     */
    public void update(String id, String name) throws Exception{

//        int staffDept = Integer.parseInt(dept);
//        this.staff = this.findById(id);

        try {
            this.department.setName(name);
//            Department department = this.em.getReference(Department.class, staffDept);
//            this.staff.setDepartment(department);

            this.em.merge(this.department);
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
     * Delete department by id
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception{
        try {
            this.department = this.findById(id);
            this.em.remove(this.department);
        }catch(TransactionalException ex){
            throw new Exception("There is no transaction for this entity manager");
        }
    }


    /**
     * Find department by id
     * @param id
     * @return
     * @throws Exception
     */
    private Department findById(String id) throws Exception{
        if(StringUtils.isBlank(id) || StringUtils.equalsIgnoreCase(id, "0"))
            throw new Exception("Invalid Department id");

        try{
            Department department = this.em.find(Department.class, Integer.parseInt(id));
            if(department == null)
                throw new Exception("Department not found");
            else
                return department;

        }catch (IllegalArgumentException ex){
            throw new Exception("Provide a valid department entity or primary key");
        }
    }


}
