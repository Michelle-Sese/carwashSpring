package carwash.project.carwashSpring.services;

import carwash.project.carwashSpring.datastore.dao.ExpensesDaoI;
import carwash.project.carwashSpring.datastore.dao.StaffDaoI;
import carwash.project.carwashSpring.datastore.model.expenses.Expenses;
import carwash.project.carwashSpring.datastore.model.staff.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ExpenseService {

    @Autowired
    private ExpensesDaoI dao;
    /**
     *
     * parentClass childClassInstance = new childClass();
     *
     * childClass childClassInstance = new parentClass();
     *
     * When a child extends parent class, child class might can override parent methods
     *
     * class Parent {
     *     void showName(){
     *         // print name
     *     }
     * }
     *
     * class Child extends Parent{
     *     void showName(){
     *         // print name
     *     }
     *
     *     void showName(){
     *         // print number
     *     }
     * }
     *
     * Parent childInstance = new  Child();
     * child.showName();
     *
     * Child childInstance = new Child();
     * child.showName();
     *
     * Child parentInstance = new Parent();
     * parentInstance.showName();
     *
     */

    public List<Expenses> list()  throws Exception{
        return dao.list();
    }

    public Expenses show(String id)  throws Exception{
        return dao.show(id);
    }

    public void create(String amount, String typeId)  throws Exception{
        dao.create(amount, typeId);
    }

    public void update(String id, String amount, String typeId)  throws Exception{
        dao.update(id, amount, typeId);
    }

    public void delete(String id)  throws Exception{
        dao.delete(id);
    }

}
