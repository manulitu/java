package com.jobs.application;

import com.jobs.domain.AbsStaffMember;

public class MemberDTO {
  public int id;
  public String name;
  public String address;
  public String phone;
  public double salaryPerMonth;
  public double totalPaid;

  public MemberDTO(AbsStaffMember staff) throws Exception {
    if (staff == null)
      throw new Exception();
    this.address = staff.getAddress();
    this.id = staff.getID();
    this.name = staff.getName();
    this.phone = staff.getPhone();
    this.salaryPerMonth = staff.getSalary();
    this.totalPaid = staff.getTotalPaid();
  }

  public MemberDTO getMember() {
    return this;
  }

  public String getMemberString() {
    return String.format("%d, %s, %s, %s, Salary: %.02f€, Paid: %.02f €", this.getID(),
        this.getName(), this.getAddress(), this.getPhone(), this.getSalary(), this.getTotalPaid());

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
