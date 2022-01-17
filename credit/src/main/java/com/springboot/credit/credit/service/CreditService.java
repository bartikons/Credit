package com.springboot.credit.credit.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.springboot.credit.credit.command.CreditCommand;
import com.springboot.credit.credit.dto.CustomerDto;
import com.springboot.credit.credit.dto.ProductDto;
import com.springboot.credit.credit.model.Credit;
import com.springboot.credit.credit.repository.CreditRepository;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreditService {
    CreditRepository creditRepository;
    Gson gson = new Gson();
    ModelMapper mapper = new ModelMapper();
    @Value("${customerUrl}")
    String urlCustomer;
    @Value("${productUrl}")
    String urlProduct;

    @Autowired
    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public ResponseEntity<List<CreditCommand>> getCreditsInfo() {
        List<Credit> listOfCredit = creditRepository.findAll();
        List<CreditCommand> listOfCreditCommands = new ArrayList<>();
        try {

            for (Credit credit : listOfCredit) {
                CreditCommand creditCommand = mapper.map(credit, CreditCommand.class);
                creditCommand.setCreditProduct(getProductInfo(credit.getId()));
                creditCommand.setCreditCustomer(getCustomerInfo(credit.getId()));
                listOfCreditCommands.add(creditCommand);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(listOfCreditCommands, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(listOfCreditCommands, HttpStatus.OK);
    }

    public ResponseEntity<Integer> createNewCredit(CreditCommand creditCommand) {

        Credit credit = mapper.map(creditCommand, Credit.class);
        credit = creditRepository.save(credit);
        ProductDto productDto = mapper.map(creditCommand, ProductDto.class);
        productDto.setCreditId(credit.getId());
        CustomerDto customerDto = mapper.map(creditCommand, CustomerDto.class);
        customerDto.setCreditId(credit.getId());
        try {
            createProduct(productDto);
            createCustomer(customerDto);
        } catch (Exception e) {
            e.printStackTrace();
            creditRepository.delete(credit);
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(credit.getId(), HttpStatus.OK);
    }

    private ProductDto getProductInfo(Integer crediId) throws IOException {
        HttpResponse response = sendRequest(urlProduct, crediId);
        HttpEntity entity = response.getEntity();
        return gson.fromJson(EntityUtils.toString(entity, "UTF-8"), ProductDto.class);

    }

    private HttpResponse createProduct(ProductDto productDto) throws IOException {
        return sendRequest(urlProduct, productDto);

    }

    private CustomerDto getCustomerInfo(Integer crediId) throws IOException {
        HttpResponse response = sendRequest(urlCustomer, crediId);
        HttpEntity entity = response.getEntity();
        return gson.fromJson(EntityUtils.toString(entity, "UTF-8"), CustomerDto.class);
    }

    private HttpResponse createCustomer(CustomerDto customerDto) throws IOException {
        return sendRequest(urlCustomer, customerDto);
    }

    private HttpResponse sendRequest(String postUrl, Object requestData) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpUriRequest post = requestData instanceof Integer
                ? RequestBuilder.get(postUrl + "?creditId=" + requestData)
                        .build()
                : RequestBuilder.post(postUrl).setEntity(new StringEntity(gson.toJson(requestData)))
                        .setHeader("Content-type", "application/json")
                        .build();
        return httpClient.execute(post);

    }
}
