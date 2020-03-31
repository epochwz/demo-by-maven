package fun.epoch.demo.service;

import fun.epoch.framework.mini.spring.beans.Component;

import java.util.Random;

@Component("salaryService")
public class SalaryService {
    public int calculateSalary(int experience) {
        return experience * (new Random().nextInt(3) + 1);
    }
}
