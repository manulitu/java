package com.jobs.domain;

public class Volunteer extends AbsStaffMember {

  protected double salaryPerMonth;
  protected IPaymentRate paymentRate;

  public Volunteer(String name, String address, String phone, double salaryPerMonth,
      IPaymentRate paymentRate) throws Exception {
    super(name, address, phone);

    // TODO
    this.paymentRate = paymentRate;
    this.salaryPerMonth = salaryPerMonth;
  }

  @Override
  public void pay() {
    // TODO
    totalPaid = paymentRate.pay(salaryPerMonth);
  }

  @Override
  public double getSalary() {
    // TODO Auto-generated method stub
    return this.salaryPerMonth;
  }

}
