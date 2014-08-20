/*
 * Copyright (c) 2012-2014, EpicSaaS Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.epicsaas.app.crm.entity.gen;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.user_id
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.company_id
     *
     * @mbggenerated
     */
    private String companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.contact_date
     *
     * @mbggenerated
     */
    private Date contactDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_crm_contact
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_contact.id
     *
     * @return the value of t_crm_contact.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.id
     *
     * @param id the value for t_crm_contact.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_contact.user_id
     *
     * @return the value of t_crm_contact.user_id
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.user_id
     *
     * @param userId the value for t_crm_contact.user_id
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_contact.company_id
     *
     * @return the value of t_crm_contact.company_id
     *
     * @mbggenerated
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.company_id
     *
     * @param companyId the value for t_crm_contact.company_id
     *
     * @mbggenerated
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_contact.contact_date
     *
     * @return the value of t_crm_contact.contact_date
     *
     * @mbggenerated
     */
    public Date getContactDate() {
        return contactDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.contact_date
     *
     * @param contactDate the value for t_crm_contact.contact_date
     *
     * @mbggenerated
     */
    public void setContactDate(Date contactDate) {
        this.contactDate = contactDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_contact.content
     *
     * @return the value of t_crm_contact.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.content
     *
     * @param content the value for t_crm_contact.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
