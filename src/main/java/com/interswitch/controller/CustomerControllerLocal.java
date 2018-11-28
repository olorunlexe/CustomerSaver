/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interswitch.controller;

import com.interswitch.model.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author therapy
 */
@Local
public interface CustomerControllerLocal {
    public void createCustomer(String name, int acctNo, String loginId, String password, String email, int mobileNo );
    public Customer getCustomer(String loginId);
    public boolean login(String password,String loginid);
}
