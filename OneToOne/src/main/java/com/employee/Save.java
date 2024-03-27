package com.employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("java");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Ramu Kumar");
        
        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setEmployeeDetail(1); 
        employeeDetail.setAddress("123 Main St, Cityville");
        employeeDetail.setPhone("9955443322");
        
        employee.setEmployeeDetail(employeeDetail);
        employeeDetail.setEmployee(employee);
        
        entityTransaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employeeDetail);
        
        entityTransaction.commit();
        
        entityManager.close();
        entityManagerFactory.close();
        
    }
}
