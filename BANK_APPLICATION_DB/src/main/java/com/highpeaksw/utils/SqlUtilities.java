package com.highpeaksw.utils;
import com.highpeaksw.accounts.*;
import com.highpeaksw.customer.BankCustomer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class SqlUtilities {

    private static SessionFactory bankCustomer;
    private static SessionFactory bankAccounts;

    public static void initHibernateConfig(){
        try {
            bankAccounts = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BankAccount.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object : BANK ACCOUNTS" + ex);
            throw new ExceptionInInitializerError(ex);
        }

        try {
            bankCustomer = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BankCustomer.class).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object : BANK CUSTOMER" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static BankCustomer dbCheckForExistingCustomer(String aadharNumber){
        Session session = bankCustomer.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List bankCustomers = session.createQuery("FROM BankCustomer").list();
            for (Iterator iterator = bankCustomers.iterator(); iterator.hasNext();){
                BankCustomer customer = (BankCustomer) iterator.next();
                if (customer.getAadharNumber().equals(aadharNumber)){
                    return customer;
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


    public static boolean addToBankCustomerTbl(BankCustomer currentInstance){
        Session session = bankCustomer.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(currentInstance);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean addToBankAccountTbl(BankAccount currentInstance){
        Session session = bankAccounts.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(currentInstance);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }


    public static boolean AccountList(int customerId){
        Session session = bankAccounts.openSession();
        Boolean isAccountHolder = false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String query_str = "FROM BankAccount WHERE customer_Id = "+customerId;
            List accounts = session.createQuery(query_str).list();
            if (accounts.size() > 0) {
                isAccountHolder = true;
                System.out.println("Your List OF Accounts :-");
                for (Iterator iterator = accounts.iterator(); iterator.hasNext(); ) {
                    BankAccount temp = (BankAccount) iterator.next();
                    System.out.print("*****   ACCOUNT TYPE : " + temp.getAccountType());
                    System.out.println("  *****   ACCOUNT NUMBER " + temp.getAccountNumber());
                }
            }
            tx.commit();
            return isAccountHolder;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isAccountHolder;
    }


    public static boolean isSavingCurrentAccountExist(int customerId, String accountType){
        Session session = bankAccounts.openSession();
        boolean isSavingCurrentAccountHolder = false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String query_str = "FROM BankAccount WHERE customer_Id = "+customerId;
            List accounts = session.createQuery(query_str).list();
            if (accounts.size() > 0) {
                for (Iterator iterator = accounts.iterator(); iterator.hasNext(); ) {
                    BankAccount temp = (BankAccount) iterator.next();
                    if (temp.getAccountType().equals(accountType)){
                        isSavingCurrentAccountHolder = true;
                        break;
                    }
                }
            }
            tx.commit();
            return isSavingCurrentAccountHolder;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isSavingCurrentAccountHolder;
    }


    public static void updateAccountTable(BankAccount updateInstance){
        Session session = bankAccounts.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(updateInstance);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public static BankAccount tryLogin(BankCustomer customerInstance){
        Session session = bankAccounts.openSession();
        Transaction tx = null;
        String accountNumber = Utilities.scanAccountNumber();
        String userName = Utilities.scanUserName();
        String password = Utilities.scanPassword();
        try {
            tx = session.beginTransaction();
            String query_str = "FROM BankAccount WHERE customer_Id = "+customerInstance.getId();
            List accounts = session.createQuery(query_str).list();
            BankAccount accountInstance = null;
            for (Iterator iterator = accounts.iterator(); iterator.hasNext(); ) {
                BankAccount temp = (BankAccount) iterator.next();
                if (Integer.parseInt(accountNumber) == temp.getAccountNumber() && userName.equals(temp.getUserName()) && password.equals(temp.getPassword())){
                    accountInstance = temp;
                    break;
                }
            }
            tx.commit();
            return accountInstance;
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }


}
