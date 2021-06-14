package com.artur_f.project.entity;


import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Transient
    private String passwordConfirm;
    @Column(name = "enabled")
    private int enabled;
    @Enumerated(EnumType.STRING)
    @Column(name = "authority")
    private Role authority;

    public Employee() {
    }

    public Employee( String name, String password, String passwordConfirm, int enabled, Role authority) {
        this.name = name;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.enabled = enabled;
        this.authority = authority;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Role getAuthority() {
        return authority;
    }

    public void setAuthority(Role authority) {
        this.authority = authority;
    }

    @Transient
    public String getRoll(Role roleEmployee){
        if(roleEmployee!=null) {
            if (roleEmployee.equals(Role.ROLE_ADMIN)) {
                return "administrator";
            } else if (roleEmployee.equals(Role.ROLE_SALES)) {
                return "sales manager";
            } else if (roleEmployee.equals(Role.ROLE_MEASURER)) {
                return "measurer";
            } else if (roleEmployee.equals(Role.ROLE_PRODUCTION)) {
                return "production";
            } else return "Error";
        }else return "";
    }

    @Transient
    public String getAccess(int Access){
        if(Access > 0){
            return "true";
        }else return "false";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + Id +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", authority=" + authority +
                '}';
    }
}
