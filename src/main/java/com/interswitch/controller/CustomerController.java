/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interswitch.controller;

import com.interswitch.model.Customer;
import com.interswitch.util.Utility;
import java.util.Date;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author therapy
 */
@Stateless
public class CustomerController implements CustomerControllerLocal {
    
    @PersistenceContext
    EntityManager em;
    @Override
    public void createCustomer(String name, int acctNo, String loginId, String password, String email, int mobileNo) {
        try {
            Customer c=new Customer();
            c.setName(name);
            c.setAccountNumber(acctNo);
            c.setDateCreated(new Date());
            c.setLoginID(loginId);
            c.setPassword(Utility.hashPassword(password));
            c.setEmail(email);
            c.setMobileNumber(mobileNo);
            em.persist(c);
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Customer getCustomer(String loginId) {
        try {
            Customer customer=(Customer) em.createNamedQuery("Customer.findByLoginID").
                    setParameter("loginID", loginId).getSingleResult();        
            return customer;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean login(String password, String loginId) {
        
        boolean isThere=false;
        try {
            Customer customer=(Customer) em.createNamedQuery("Customer.findByLogin").
                setParameter("loginID", loginId).
                setParameter("password",Utility.hashPassword(password)).getSingleResult();
        //Utility.hashPassword(password)
        if (customer!=null) {
            isThere=true;
        }
        //return true;
        //return false;
        return isThere;
        } catch (Exception e) {
            return false;
        }
        
    }

   
        
 }

