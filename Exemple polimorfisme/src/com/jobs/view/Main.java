package com.jobs.view;

import java.util.ArrayList;
import java.util.List;

import com.jobs.application.JobsController;
import com.jobs.application.MemberDTO;

public class Main {

  private static JobsController controller = new JobsController();

  public static void main(String[] args) throws Exception {

    controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 100.0);
    controller.createEmployee("Pedro Employee", "Dirección molona 2", "665266666", 40.0);
    controller.createEmployee("Laura Employee", "Dirección molona 3", "625266666", 45.0);
    controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
    controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 80.0);

    controller.payAllEmployeers();

    List<MemberDTO> allEmployees = new ArrayList<MemberDTO>();
    allEmployees = controller.getAllEmployees();
    String mem = "";
    System.out.print("EMPLOYEES: ");
    for (MemberDTO member : allEmployees) {
      mem = member.getMemberString();
      System.out.println(mem);
    }
    System.out.print("\n");

    controller.removeMember("Laura Employee");
    allEmployees = controller.getAllEmployees();

    System.out.print("EMPLOYEES: ");
    for (MemberDTO member : allEmployees) {
      mem = member.getMemberString();
      System.out.println(mem);
    }
    System.out.print("\n");

    controller.removeMember("Juan Volunteer");
    allEmployees = controller.getAllEmployees();
    System.out.print("EMPLOYEES: ");
    for (MemberDTO member : allEmployees) {
      mem = member.getMemberString();
      System.out.println(mem);
    }
    System.out.print("\n");

  }

}
