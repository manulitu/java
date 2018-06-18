package com.jobs.application;

import java.util.ArrayList;
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
    Employee manager = new Employee(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateManager());
    repository.addMember(manager);
  }

  public void createVolunteer(String name, String address, String phone) throws Exception {
    double salaryPerMonth = 0.0;
    Volunteer volunteer = new Volunteer(name, address, phone, salaryPerMonth,
        PaymentFactory.createPaymentRateVounteer());
    repository.addMember(volunteer);

  }

  public void payAllEmployeers() {
    for (AbsStaffMember staff : repository.getAllMembers()) {
      staff.pay();
    }

  }

  public ArrayList<MemberDTO> getAllEmployees() throws Exception {
    ArrayList<MemberDTO> employees = new ArrayList<MemberDTO>();
    for (AbsStaffMember staff : repository.getAllMembers()) {
      MemberDTO dto = new MemberDTO(staff);
      employees.add(dto);
    }
    return employees;
  }

  public void removeMember(String name) throws Exception {
    List<AbsStaffMember> list = repository.getAllMembers();
    for (AbsStaffMember m : list) {
      if (name.equals(m.getName())) {
        repository.removeMember(m);
      }
    }
  }

}
