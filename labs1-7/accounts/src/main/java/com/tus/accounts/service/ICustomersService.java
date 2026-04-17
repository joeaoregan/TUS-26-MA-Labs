package com.tus.accounts.service;

import com.tus.accounts.dto.CustomerDetailsDto;

public interface ICustomersService {

	CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
