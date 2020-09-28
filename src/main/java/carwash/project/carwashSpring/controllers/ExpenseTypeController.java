package carwash.project.carwashSpring.controllers;

import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.expenseType.ExpenseType;
import carwash.project.carwashSpring.services.DepartmentService;
import carwash.project.carwashSpring.services.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expense")
public class ExpenseTypeController {

    @Autowired
    private ExpenseTypeService expenseTypeService;

    /**
     *  Get records of ExpenseType
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ExpenseType> list() throws Exception{
        return  expenseTypeService.list();
    }

    /**
     * Get 1 ExpenseType record by id
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ExpenseType show(@PathVariable String id)  throws Exception{
        return expenseTypeService.show(id);
    }

    /**
     * Create new ExpenseType
     * @param name
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create( @RequestParam("name") String name) throws Exception{
        expenseTypeService.create(name);
    }

    /**
     * Update existing ExpenseType by id
     * @param id
     * @param name
     * @throws Exception
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update( @RequestParam("id") String id,
                        @RequestParam("name") String name) throws Exception{
        expenseTypeService.update(id, name);
    }

    /**
     * Delete ExpenseType by id
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete( @RequestParam("id") String id) throws Exception{
        expenseTypeService.delete(id);
    }


}

