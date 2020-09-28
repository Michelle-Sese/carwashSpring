package carwash.project.carwashSpring.controllers;


import carwash.project.carwashSpring.datastore.model.expenses.Expenses;
import carwash.project.carwashSpring.datastore.model.services.Services;
import carwash.project.carwashSpring.services.ExpenseService;
import carwash.project.carwashSpring.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    /**
     *  Get records of services
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Services> list() throws Exception{
        return  servicesService.list();
    }

    /**
     * Get 1 Services record by id
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Services show(@PathVariable String id)  throws Exception{
        return servicesService.show(id);
    }

    /**
     * Create new Services
     * @param amount
     * @param typeId
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create( @RequestParam("amount") String amount,
                        @RequestParam("typeId") String typeId) throws Exception{
        servicesService.create(amount,typeId);
    }

    /**
     * Update existing Services by id
     * @param typeId
     * @param amount
     * @throws Exception
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(
            @RequestParam("amount") String amount,
            @RequestParam("typeId") String typeId) throws Exception{
        servicesService.update(amount, typeId);
    }

    /**
     * Delete Services by id
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete( @RequestParam("id") String id) throws Exception{
        servicesService.delete(id);
    }

}
