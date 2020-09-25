package carwash.project.carwashSpring.controllers;

import carwash.project.carwashSpring.datastore.model.staff.Staff;
import carwash.project.carwashSpring.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    /**
     *  Get records of staff
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Staff> list() throws Exception{
        return  staffService.list();
    }

    /**
     * Get 1 staff record by id
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Staff show(@PathVariable String id)  throws Exception{
        return staffService.show(id);
    }

    /**
     * Create new staff
     * @param fname
     * @param lname
     * @param email
     * @param password
     * @param dept
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create( @RequestParam("fname") String fname,
                        @RequestParam("lname") String lname,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("dept") String dept) throws Exception{
        staffService.create(fname, lname, email, password, dept);
    }

    /**
     * Update existing staff by id
     * @param id
     * @param fname
     * @param lname
     * @param email
     * @param password
     * @param dept
     * @throws Exception
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update( @RequestParam("id") String id,
                        @RequestParam("fname") String fname,
                        @RequestParam("lname") String lname,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("dept") String dept) throws Exception{
        staffService.update(id, fname, lname, email, password, dept);
    }

    /**
     * Delete staff by id
     * @param id
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete( @RequestParam("id") String id) throws Exception{
        staffService.delete(id);
    }

}
