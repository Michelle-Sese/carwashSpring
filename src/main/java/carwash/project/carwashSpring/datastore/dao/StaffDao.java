package carwash.project.carwashSpring.datastore.dao;

import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.staff.Staff;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.TransactionalException;
import java.util.List;

@Repository
public class StaffDao implements StaffDaoI{

    @PersistenceContext
    private EntityManager em;

    Staff staff = new Staff();

    /**
     * List staff
     * @return
     * @throws Exception
     */
    public List<Staff> list() throws Exception{
        String hql = "SELECT U FROM Staff U";
        try{
            return this.em.createQuery(hql).getResultList();
        }catch(IllegalArgumentException ex){
            throw new Exception("Invalid query");
        }
        catch(NoResultException ex){
            throw new Exception("No staff found");
        }
    }

    /**
     * Show staff by id
     * @param id
     * @return
     * @throws Exception
     */
    public Staff show(String id) throws Exception {
        return this.findById(id);
    }

    /**
     * save new staff
     * @param fname
     * @param lname
     * @param email
     * @param password
     * @param dept
     * @throws Exception
     */
    public void create(String fname, String lname, String email, String password, String dept) throws Exception{

        int staffDept = Integer.parseInt(dept);

        try {
            this.staff.setfName(fname);
            this.staff.setlName(lname);
            this.staff.setEmail(email);
            this.staff.setPassword(password);

            Department department = this.em.getReference(Department.class, staffDept);
            this.staff.setDepartment(department);

            this.em.merge(this.staff);
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
     * update staff
     * @param fname
     * @param lname
     * @param email
     * @param password
     * @param dept
     * @throws Exception
     */
    public void update(String id, String fname, String lname, String email, String password, String dept) throws Exception{

        int staffDept = Integer.parseInt(dept);
        this.staff = this.findById(id);

        try {
            this.staff.setfName(fname);
            this.staff.setlName(lname);
            this.staff.setEmail(email);
            this.staff.setPassword(password);

            Department department = this.em.getReference(Department.class, staffDept);
            this.staff.setDepartment(department);

            this.em.merge(this.staff);
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
     * Delete staff by id
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception{
        try {
            this.staff = this.findById(id);
            this.em.remove(this.staff);
        }catch(TransactionalException ex){
            throw new Exception("There is no transaction for this entity manager");
        }
    }


    /**
     * Find staff by id
     * @param id
     * @return
     * @throws Exception
     */
    private Staff findById(String id) throws Exception{
        if(StringUtils.isBlank(id) || StringUtils.equalsIgnoreCase(id, "0"))
            throw new Exception("Invalid staff id");

        try{
            Staff staff = this.em.find(Staff.class, Integer.parseInt(id));
            if(staff == null)
                throw new Exception("Staff not found");
            else
                return staff;

        }catch (IllegalArgumentException ex){
            throw new Exception("Provide a valid staff entity or primary key");
        }
    }


}
