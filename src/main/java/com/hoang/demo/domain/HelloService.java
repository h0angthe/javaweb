package com.hoang.demo.domain;

import com.hoang.demo.infra.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {

    int id ;

    List<Customer> customerList = new ArrayList<>();

    public List<Customer> getCustomerList () {
        return customerList;
    }

    public String addNew(Customer customer) {
        customer.setId(id++);
        customer.setAge(customer.getAge());
        customer.setName(customer.getName());
        customerList.add(customer);

        return "add new success";
    }

    public String put(Customer customer){
        for(Customer ct : customerList){
            if(ct.getId() == customer.getId()){
                ct.setName(customer.getName());
                ct.setAge(customer.getAge());
            }
        }
       return "Sửa thành công";
    }

    public String del(Customer customer) {
        int check = 0;
        for(int i = 0; i < customerList.size();i++){
            if(customer.getId() == customerList.get(i).getId()){
                customerList.remove(i);
                check++;
            }
        }
        if(check == 0){
            return "Không có id";
        }
        return "Bạn đã xóa thành công";
    }

    public Customer searchId(int id){
        List<Customer> cs = new ArrayList<>();
        for (Customer ct: customerList) {
            if(ct.getId()== id)
                return ct;
        }
       return null ;
    }
    public List<Customer> getCustomerbyName(String name){
        List<Customer> dsUser = new ArrayList<>();
        for(int i =0;i < customerList.size();i++){
            if(customerList.get(i).getName().contains(name)){
                dsUser.add(customerList.get(i));
            }
        }
        return dsUser ;
    }
}
