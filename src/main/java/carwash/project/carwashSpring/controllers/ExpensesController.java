package carwash.project.carwashSpring.controllers;

import carwash.project.carwashSpring.datastore.model.expenses.Expenses;
import carwash.project.carwashSpring.datastore.model.staff.Staff;
import carwash.project.carwashSpring.services.ExpenseService;
import carwash.project.carwashSpring.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    private ExpenseService expenseService;

    /**
     *  Get records of expenses
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Expenses> list() throws Exception{
        return  expenseService.list();
    }

    /**
     * Get 1 expenses record by id
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Expenses show(@PathVariable String id)  throws Exception{
        return expenseService.show(id);
    }

    /**
     * Create new expenses
     * @param amount
     * @param typeId
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create( @RequestParam("amount") String amount,
                        @RequestParam("typeId") String typeId) throws Exception{
        expenseService.create(amount,typeId);
    }

    /**
     * Update existing expenses by id
     * @param id
     * @param amount
     * @throws Exception
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update( @RequestParam("id") String id,
                        @RequestParam("amount") String amount,
                        @RequestParam("typeId") String typeId) throws Exception{
        expenseService.update(id, amount, typeId);
    }

    /**
     * Delete expenses by id
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete( @RequestParam("id") String id) throws Exception{
        expenseService.delete(id);
    }

}
