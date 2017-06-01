package com.userapi.entity;

import javax.persistence.*;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "user")
@Indexed
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String fname;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String lname;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String address;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String contact;
    
    
    public User() {
		super();
	}

	public User(String fname, String lname, String address, String contact) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.contact = contact;
	}
	
	

	public User(int userid, String fname, String lname, String address, String contact) {
		super();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.contact = contact;
	}

	public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", contact=" + contact + "]";
	}
    
    
}
