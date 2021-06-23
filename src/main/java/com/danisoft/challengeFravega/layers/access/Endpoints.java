package com.danisoft.challengeFravega.layers.access;

public class Endpoints {

    public static final String BASE_PATH = "/api/v1.0";

    public static final String BRANCH_OFFICE = BASE_PATH + "/branch-office";
    public static final String BRANCH_OFFICE_CREATE_ONE = BRANCH_OFFICE;
    public static final String BRANCH_OFFICE_READ_ONE = BASE_PATH + "/branch-office/{id}" ;
    public static final String BRANCH_OFFICE_UPDATE_ONE = BASE_PATH + "/branch-office/{id}" ;
    public static final String BRANCH_OFFICE_DELETE_ONE = BASE_PATH + "/branch-office/{id}" ;

    public static final String WITHDRAWAL_POINT = BASE_PATH + "/withdrawal-point";
    public static final String WITHDRAWAL_POINT_CREATE_ONE = WITHDRAWAL_POINT;
    public static final String WITHDRAWAL_POINT_READ_ONE = BASE_PATH + "/withdrawal-point/{id}" ;
    public static final String WITHDRAWAL_POINT_UPDATE_ONE = BASE_PATH + "/withdrawal-point/{id}" ;
    public static final String WITHDRAWAL_POINT_DELETE_ONE = BASE_PATH + "/withdrawal-point/{id}" ;

}
