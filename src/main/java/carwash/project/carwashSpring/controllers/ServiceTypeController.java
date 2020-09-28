package carwash.project.carwashSpring.controllers;


import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.serviceType.ServiceType;
import carwash.project.carwashSpring.services.DepartmentService;
import carwash.project.carwashSpring.services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    /**
     *  Get records of service
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ServiceType> list() throws Exception{
        return  serviceTypeService.list();
    }

    /**
     * Get 1 service record by id
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ServiceType show(@PathVariable String id)  throws Exception{
        return serviceTypeService.show(id);
    }

    /**
     * Create new service
     * @param name
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create( @RequestParam("name") String name) throws Exception{
        serviceTypeService.create(name);
    }

    /**
     * Update existing service by id
     * @param id
     * @param name
     * @throws Exception
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update( @RequestParam("id") String id,
                        @RequestParam("name") String name) throws Exception{
        serviceTypeService.update(id, name);
    }

    /**
     * Delete service by id
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete( @RequestParam("id") String id) throws Exception{
        serviceTypeService.delete(id);
    }


}