package com.jobs.application;

import com.jobs.domain.AbsStaffMember;

public class MemberDTO {
  public int id;
  public String name;
  public String address;
  public String phone;
  public double salaryPerMonth;
  public double totalPaid;

  public MemberDTO(AbsStaffMember a) {
    this.address = a.getAddress();
    this.id = a.getID();
    this.name = a.getName();
    this.phone = a.getPhone();
    this.salaryPerMonth = a.getSalary();
    this.totalPaid = a.getTotalPaid();
  }

  public int getID() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return this.address;
  }

  public String getPhone() {
    return this.phone;
  }

  public double getSalary() {
    return this.salaryPerMonth;
  }

  public double getTotalPaid() {
    return this.totalPaid;
  }

}
