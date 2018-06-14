package com.jobs.application;

import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

  private EmployeeRepository repository;

  public JobsController() {
    repository = new EmployeeRepository();
  }

  public void createBossEmployee(String name, String address, String phone, double salaryPerMonth)
      throws Exception {
    Employee boss = new Employee(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateBoss());
    repository.addMember(boss);
  }

  public void createEmployee(String name, String address, String phone, double salaryPerMonth)
      throws Exception {
    Employee employee = new Employee(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateEmployee());
    repository.addMember(employee);
  }

  public void createManagerEmployee(String name, String address, String phone,
      double salaryPerMonth) throws Exception {
    // TODO Auto-generated method stub
    Employee manager = new Employee(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateManager());
    repository.addMember(manager);
  }

  public void createVolunteer(String string, String string2, String string3) throws Exception {
    // TODO Auto-generated method stub
    double salaryPerMonth = 0.0;
    Volunteer volunteer = new Volunteer(string, string2, string3, salaryPerMonth,
        PaymentFactory.createPaymentRateVounteer());
    repository.addMember(volunteer);

  }

  public void payAllEmployeers() {
    // TODO Auto-generated method stub
    for (AbsStaffMember e : repository.getAllMembers()) {
      e.pay();
    }

  }

  public String getAllEmployees() {
    // TODO Auto-generated method stub
    String employees = "";
    String value = "";
    for (AbsStaffMember e : repository.getAllMembers()) {
      MemberDTO dto = new MemberDTO(e);
      value = String.format("%d, %s, %s, %s, Salary: %.02f€, Paid: %.02f €", dto.getID(),
          dto.getName(), dto.getAddress(), dto.getPhone(), dto.getSalary(), dto.getTotalPaid());
      employees += value + "\n";

    }
    return employees;
  }

  public void removeMember(String name) throws Exception {
    List<AbsStaffMember> list = repository.getAllMembers();
    for (AbsStaffMember m : list) {
      if (name.equals(m.getName())) {
        System.out.println("Member " + name + " is being removed.");
        repository.removeMember(m);
      }
    }
  }

}
