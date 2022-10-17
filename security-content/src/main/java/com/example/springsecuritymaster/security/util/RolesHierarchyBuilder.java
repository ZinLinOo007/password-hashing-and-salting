package com.example.springsecuritymaster.security.util;

public class RolesHierarchyBuilder {
    private StringBuilder stringBuilder = new StringBuilder();

    public RolesHierarchyBuilder append(String uplineRoles , String downlineRoles){
        stringBuilder.append(
                String.format("ROLE_%s > ROLE_%s\n",uplineRoles,downlineRoles)
        );

        return this;
    }

    public String build(){
        return stringBuilder.toString();
    }

}
