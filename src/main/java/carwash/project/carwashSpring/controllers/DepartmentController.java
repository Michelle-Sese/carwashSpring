package carwash.project.carwashSpring.controllers;


import carwash.project.carwashSpring.datastore.model.departments.Department;
import carwash.project.carwashSpring.datastore.model.staff.Staff;
import carwash.project.carwashSpring.services.DepartmentService;
import carwash.project.carwashSpring.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     *  Get records of department
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Department> list() throws Exception{
        return  departmentService.list();
    }

    /**
     * Get 1 department record by id
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Department show(@PathVariable String id)  throws Exception{
        return departmentService.show(id);
    }

    /**
     * Create new department
     * @param name
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create( @RequestParam("name") String name) throws Exception{
        departmentService.create(name);
    }

    /**
     * Update existing department by id
     * @param id
     * @param name
     * @throws Exception
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update( @RequestParam("id") String id,
                        @RequestParam("name") String name) throws Exception{
        departmentService.update(id, name);
    }

    /**
     * Delete department by id
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete( @RequestParam("id") String id) throws Exception{
        departmentService.delete(id);
    }


}
