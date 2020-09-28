package carwash.project.carwashSpring.services;

import carwash.project.carwashSpring.datastore.dao.DepartmentDaoI;
import carwash.project.carwashSpring.datastore.dao.ExpenseTypeDaoI;
import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.expenseType.ExpenseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExpenseTypeService {

    @Autowired
    private ExpenseTypeDaoI dao;
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

    public List<ExpenseType> list()  throws Exception{
        return dao.list();
    }

    public ExpenseType show(String id)  throws Exception{
        return dao.show(id);
    }

    public void create(String name)  throws Exception{
        dao.create(name);
    }

    public void update(String id, String name)  throws Exception{
        dao.update(id, name);
    }

    public void delete(String id)  throws Exception{
        dao.delete(id);
    }

}


