package org.example.shell.client;

import org.example.shell.response.PolicyResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface PolicyClient {

    @GetExchange("/policy/{key}")
    PolicyResponse getPolicyByKey(@PathVariable String key);

    @GetExchange("/policy/")
    List<PolicyResponse> getAllPolicies();
}
