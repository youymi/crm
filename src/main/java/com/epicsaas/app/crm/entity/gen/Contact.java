package com.epicsaas.app.crm.entity.gen;

import java.io.Serializable;

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
     * This field corresponds to the database column t_crm_contact.company_id
     *
     * @mbggenerated
     */
    private String companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.position
     *
     * @mbggenerated
     */
    private String position;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.phone
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_crm_contact.level
     *
     * @mbggenerated
     */
    private String level;

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
     * This method returns the value of the database column t_crm_contact.name
     *
     * @return the value of t_crm_contact.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.name
     *
     * @param name the value for t_crm_contact.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_contact.position
     *
     * @return the value of t_crm_contact.position
     *
     * @mbggenerated
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.position
     *
     * @param position the value for t_crm_contact.position
     *
     * @mbggenerated
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_contact.phone
     *
     * @return the value of t_crm_contact.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.phone
     *
     * @param phone the value for t_crm_contact.phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_contact.email
     *
     * @return the value of t_crm_contact.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.email
     *
     * @param email the value for t_crm_contact.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_contact.remark
     *
     * @return the value of t_crm_contact.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.remark
     *
     * @param remark the value for t_crm_contact.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_crm_contact.level
     *
     * @return the value of t_crm_contact.level
     *
     * @mbggenerated
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_crm_contact.level
     *
     * @param level the value for t_crm_contact.level
     *
     * @mbggenerated
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }
}