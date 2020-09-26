package carwash.project.carwashSpring.controllers;

import carwash.project.carwashSpring.datastore.model.accounts.Accounts;
import carwash.project.carwashSpring.datastore.model.staff.Staff;
import carwash.project.carwashSpring.services.AccountService;
import carwash.project.carwashSpring.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private AccountService accountService;

    /**
     *  Get records of accounts
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Accounts> list() throws Exception{
        return  accountService.list();
    }

    /**
     * Get 1 account record by id
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Accounts show(@PathVariable String id)  throws Exception{
        return accountService.show(id);
    }

    /**
     * Create new account
     * @param expenditure
     * @param revenue
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create( @RequestParam("expenditure") String expenditure,
                        @RequestParam("revenue") String revenue) throws Exception
            {
             accountService.create(expenditure, revenue);
           }

    /**
     * Update existing account by id
     * @param id
     * @param expenditure
     * @param revenue
     * @throws Exception
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update( @RequestParam("id") String id,
                        @RequestParam("expenditure") String expenditure,
                        @RequestParam("revenue") String revenue) throws Exception
     {
        accountService.update(id, expenditure, revenue);
    }

    /**
     * Delete accounts by id
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete( @RequestParam("id") String id) throws Exception{
        accountService.delete(id);
    }

}
