package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

  public static IPaymentRate createPaymentRateBoss() {
    return new IPaymentRate() {
      @Override
      public double pay(double salaryPerMonth) {
        return salaryPerMonth * 1.5;
      }
    };
  }

  public static IPaymentRate createPaymentRateEmployee() {
    return new IPaymentRate() {
      @Override
      public double pay(double salaryPerMonth) {
        return salaryPerMonth * 0.85;// it reduces the salary a 15%.
      }
    };
  }

  public static IPaymentRate createPaymentRateManager() {
    return new IPaymentRate() {
      @Override
      public double pay(double salaryPerMonth) {
        return salaryPerMonth * 1.10;// it increases the salary a 10%.
      }
    };
  }

  public static IPaymentRate createPaymentRateVounteer() {
    return new IPaymentRate() {
      @Override
      public double pay(double salaryPerMonth) {
        return salaryPerMonth * 0.00;// it eliminates payment.
      }
    };
  }

}