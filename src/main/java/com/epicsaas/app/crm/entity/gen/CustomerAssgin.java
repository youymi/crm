package com.epicsaas.app.crm.entity.gen;

import java.io.Serializable;
import java.util.Date;

public class CustomerAssgin implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_customer_assign.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_customer_assign.customer_id
     *
     * @mbggenerated
     */
    private String customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_customer_assign.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_customer_assign.date
     *
     * @mbggenerated
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_crm_customer_assign
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_customer_assign.id
     *
     * @return the value of t_crm_customer_assign.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_customer_assign.id
     *
     * @param id the value for t_crm_customer_assign.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_customer_assign.customer_id
     *
     * @return the value of t_crm_customer_assign.customer_id
     *
     * @mbggenerated
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_customer_assign.customer_id
     *
     * @param customerId the value for t_crm_customer_assign.customer_id
     *
     * @mbggenerated
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_customer_assign.user_id
     *
     * @return the value of t_crm_customer_assign.user_id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_customer_assign.user_id
     *
     * @param userId the value for t_crm_customer_assign.user_id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_customer_assign.date
     *
     * @return the value of t_crm_customer_assign.date
     *
     * @mbggenerated
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_customer_assign.date
     *
     * @param date the value for t_crm_customer_assign.date
     *
     * @mbggenerated
     */
    public void setDate(Date date) {
        this.date = date;
    }
}