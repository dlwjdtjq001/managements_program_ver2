package employee.controller;

import employee.dto.EmployeeDto;
import employee.service.EmployeeCreateService;
import employee.service.EmployeeReadService;

import java.util.List;
import java.util.Scanner;

import static common.EmployeeText.*;
import static common.ErrorCode.*;

public class EmployeeCreateContImp implements EmployeeCreateCont {

    Scanner in = new Scanner(System.in);
    private final String NUMBER_REGEX = "^[1-9][0-9]*$";
    private final String EMPLOYEE_NAME_REGEX = "^[가-힣]{2,10}$";
    private final String ENTERYEAR_REGEX = "^[1-9][0-9]{0,3}$";
    private final String ENTERMONTH_REGEX = "^(1[0-2]|[1-9])$";
    private final String ENTERDAY_REGEX = "^(3[0-1]|[1-2][0-9]|[1-9])$";
    private final String SECINPUT_REGEX = "^(1[0-4][0-9])$";


    private final EmployeeCreateService createService;
    private final EmployeeReadService readService;


    public EmployeeCreateContImp(EmployeeCreateService createService, EmployeeReadService readService) {
        this.createService = createService;
        this.readService = readService;

    }


    @Override
    public EmployeeDto create() {

        EmployeeDto employeeDto = new EmployeeDto();

        List<EmployeeDto> employeeDtoList = readService.ReadAll();

        System.out.println(ENTER_INPUT_EMPLOYEE.getText());
        int inputEno = 0;
        if (employeeDtoList.isEmpty()) {
            inputEno = 0;
        } else {
            inputEno = employeeDtoList.get(employeeDtoList.size() - 1).getEno();
        }
        employeeDto.setEno(inputEno + 1);

        employeeDto.setName(inputName());
        System.out.printf(ENTER_ENTRY_YEAR.getText());
        employeeDto.setEnteryear(inputNumRegex(ENTERYEAR_REGEX));
        System.out.printf(ENTER_ENTRY_MONTH.getText());
        employeeDto.setEntermonth(inputNumRegex(ENTERMONTH_REGEX));
        System.out.printf(ENTER_ENTRY_DAY.getText());
        employeeDto.setEnterday(inputNumRegex(ENTERDAY_REGEX));
        System.out.printf(ENTER_ROLE.getText());
        System.out.println(INPUT_ROLE.getText());
        System.out.println(ENTER_CHOICE.getText());
        String roleinput = null;
        switch (inputNum()){
            case 1 -> roleinput = "Staff";
            case 2 -> roleinput = "Manager";
            case 3 -> roleinput = "Secretary";
            default -> roleinput = "Staff";
        }
        employeeDto.setRole(roleinput);
        System.out.printf(ENTER_SECTION_NUMBER.getText());
        System.out.println(INPUT_SECNO.getText());
        employeeDto.setSecno(inputNumRegex(SECINPUT_REGEX));
        System.out.printf(ENTER_SALARY.getText());
        employeeDto.setSalary(inputNum());

        return createService.create(employeeDto);
    }

    @Override
    public void createrun(){

        EmployeeDto createEmployee = create();

        if (createEmployee.getEno() == null){
            System.out.println(EMPLOYEE_CREATE_FAIL.getText());
            return;
        }else {
            System.out.println(EMPLOYEE_CREATE_SUCCESS.getText());
            System.out.println(PRINT_TITLE.getText());
            System.out.println(PRINT_ROUND.getText());
            System.out.printf("%-5d %-10s %2d-%02d-%02d  %-12s %8d %,14d\n",
                    createEmployee.getEno(),createEmployee.getName(),
                    createEmployee.getEnteryear(),createEmployee.getEntermonth(),createEmployee.getEnterday(),
                    createEmployee.getRole(),createEmployee.getSecno(),createEmployee.getSalary());
        }
    }

    private int inputNum(){
        String str;
        int input = 0;
        while (true){
            str = in.nextLine();
            if (str.matches(NUMBER_REGEX)){
                input = Integer.parseInt(str);
                break;
            }
            System.out.println(ERROR_NUM.getText());
        }
        return input;
    }

    private String inputName(){
        String name;
        do {
            System.out.printf(ENTER_NAME.getText());
            name = in.nextLine();
        } while (!(!name.trim().isEmpty()
                && name.matches(EMPLOYEE_NAME_REGEX)));
        return name;
    }

    private int inputNumRegex(String regex){
        String str;
        int input = 0;
        while (true){
            str = in.nextLine();
            if (str.matches(regex)){
                input = Integer.parseInt(str);
                break;
            }
            System.out.println(ERROR_NUM.getText());
        }
        return input;
    }
}