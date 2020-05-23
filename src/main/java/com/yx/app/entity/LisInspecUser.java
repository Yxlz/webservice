package com.yx.app.entity;

import java.util.Date;

public class LisInspecUser {
    private String id;

    private String username;

    private String hisId;

    private String usernameCn;

    private String inspecName;

    private String password;

    private String deptId;

    private String enabled;

    private String devCodes;

    private String role;

    private String permissions;

    private String hospitalId;

    private Date pupdateTime;

    private String changeAuditPassword;

    private String clientId;

    private String autoGraph;

    public LisInspecUser(String id, String username, String hisId, String usernameCn, String inspecName, String password, String deptId, String enabled, String devCodes, String role, String permissions, String hospitalId, Date pupdateTime, String changeAuditPassword, String clientId, String autoGraph) {
        this.id = id;
        this.username = username;
        this.hisId = hisId;
        this.usernameCn = usernameCn;
        this.inspecName = inspecName;
        this.password = password;
        this.deptId = deptId;
        this.enabled = enabled;
        this.devCodes = devCodes;
        this.role = role;
        this.permissions = permissions;
        this.hospitalId = hospitalId;
        this.pupdateTime = pupdateTime;
        this.changeAuditPassword = changeAuditPassword;
        this.clientId = clientId;
        this.autoGraph = autoGraph;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getHisId() {
        return hisId;
    }

    public String getUsernameCn() {
        return usernameCn;
    }

    public String getInspecName() {
        return inspecName;
    }

    public String getPassword() {
        return password;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getEnabled() {
        return enabled;
    }

    public String getDevCodes() {
        return devCodes;
    }

    public String getRole() {
        return role;
    }

    public String getPermissions() {
        return permissions;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public Date getPupdateTime() {
        return pupdateTime;
    }

    public String getChangeAuditPassword() {
        return changeAuditPassword;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAutoGraph() {
        return autoGraph;
    }
}