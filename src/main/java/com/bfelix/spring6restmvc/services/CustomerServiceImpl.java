package com.bfelix.spring6restmvc.services;

import com.bfelix.spring6restmvc.model.CustomerDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("CustomerDTO 1")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO2 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("CustomerDTO 2")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO3 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("CustomerDTO 3")
                .version(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        customerMap = new HashMap<>();
        customerMap.put(customerDTO1.getId(), customerDTO1);
        customerMap.put(customerDTO2.getId(), customerDTO2);
        customerMap.put(customerDTO3.getId(), customerDTO3);
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customerDTO) {
        CustomerDTO existing = customerMap.get(customerId);

        if (StringUtils.hasText(customerDTO.getName())) {
            existing.setName(customerDTO.getName());
        }
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customerDTO) {
        CustomerDTO existing = customerMap.get(customerId);
        existing.setName(customerDTO.getName());
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {

        CustomerDTO savedCustomerDTO = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .updateDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .name(customerDTO.getName())
                .build();

        customerMap.put(savedCustomerDTO.getId(), savedCustomerDTO);

        return savedCustomerDTO;
    }

    @Override
    public CustomerDTO getCustomerById(UUID uuid) {
        return customerMap.get(uuid);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }
}
