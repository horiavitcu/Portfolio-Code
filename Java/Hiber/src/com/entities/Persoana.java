/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HHHHH
 */
@Entity
@Table(name = "persoane")
public class Persoana implements Identifiable, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
        
        
	private Long id = null;
	//
	@Basic(optional = false)
	@Column(name = "nume")
        
        
	private String nume = "";
	//
	@Basic(optional = false)
	@Column(name = "prenume")
        
        
	private String prenume = "";
	//
	@Basic(optional = false)
	@Column(name = "sex")
        
        
	private String sex = "";
	//
	@Basic(optional = false)
	@Column(name = "varsta")
        
        
	private Integer varsta = null;

    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nume
     */
    public String getNume() {
        return nume;
    }

    /**
     * @param nume the nume to set
     */
    public void setNume(String nume) {
        this.nume = nume;
    }

    /**
     * @return the prenume
     */
    public String getPrenume() {
        return prenume;
    }

    /**
     * @param prenume the prenume to set
     */
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the varsta
     */
    public Integer getVarsta() {
        return varsta;
    }

    /**
     * @param varsta the varsta to set
     */
    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }
}	
	