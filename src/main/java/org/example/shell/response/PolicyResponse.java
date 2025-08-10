package org.example.shell.response;

import lombok.Data;

@Data
public class PolicyResponse {

    private Long id;
    private String policyKey;
    private Integer policyValue;

    @Override
    public String toString() {
        return id + ". " + policyKey + ": " + policyValue;
    }
}
