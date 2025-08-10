package org.example.shell.command;

import lombok.RequiredArgsConstructor;
import org.example.shell.client.PolicyClient;
import org.example.shell.response.PolicyResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class PolicyCommand {

    private final PolicyClient policyClient;

    @ShellMethod(key = "policy get", value = "Get policy by key")
    public String getPolicyByKey(String key) {
        PolicyResponse policyResponse = policyClient.getPolicyByKey(key);
        return policyResponse.toString();
    }

    @ShellMethod(key = "policy ls", value = "List all policies")
    public String listPolicies() {
        return policyClient.getAllPolicies().stream()
                .map(PolicyResponse::toString)
                .collect(Collectors.joining("\n"));
    }
}
