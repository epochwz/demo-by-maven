package fun.epoch.demo.controller;

import fun.epoch.demo.service.SalaryService;
import fun.epoch.framework.mini.spring.beans.Autowired;
import fun.epoch.framework.mini.spring.web.mvc.Controller;
import fun.epoch.framework.mini.spring.web.mvc.RequestMapping;
import fun.epoch.framework.mini.spring.web.mvc.RequestParam;

@Controller("salaryController")
@RequestMapping("/salary")
public class SalaryController {

    @Autowired("salaryService")
    private SalaryService salaryService;

    @RequestMapping("/calc")
    public String calc(@RequestParam("name") String name, @RequestParam("experience") String experience) {
        int salary = salaryService.calculateSalary(Integer.parseInt(experience));
        return String.format("%s's salary is %s", name, salary);
    }
}
