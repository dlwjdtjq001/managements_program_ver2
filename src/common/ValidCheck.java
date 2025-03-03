package common;


import java.util.Scanner;

/**
 * 직원 정보 유효성 검사 클래스
 */
public class ValidCheck {
    private static final String EMPLOYEE_NUMBER_REGEX = "^[1-9][0-9]*$";
    private static final String EMPLOYEE_NAME_REGEX = "^[a-zA-Z가-힣]{2,10}$";
    private static final String EMPLOYEE_ROLE_REGEX = "^[a-zA-Z가-힣]{2,20}$";
    private static final String EMPLOYEE_SALARY_REGEX = "^\\d{1,8}$";


    /**
     * 직원 번호 입력 및 유효성 검사
     */
    public int getValidEmployeeNumber(Scanner scanner) {
        int eno;
        while (true) {
            System.out.print(EmployeeText.ENTER_EMPLOYEE_NUMBER.getText());
            try {
                String input = scanner.nextLine();
                eno = Integer.parseInt(input);
                isValidEmployeeNumber(eno);
                return eno;
            } catch (NumberFormatException e) {
                System.out.println(ErrorCode.INVALID_EMPLOYEE_NUMBER.getText());
            } catch (IllegalArgumentException e) { // ✅ 이후 유효성 검사 예외 처리
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 직원 번호 유효성 검사
     */
    public void isValidEmployeeNumber(Integer eno) {
        if (eno == null || !String.valueOf(eno).matches(EMPLOYEE_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_EMPLOYEE_NUMBER.getText());
        }
    }

    /**
     * 직원 이름 유효성 검사
     */
    public void isValidEmployeeName(String name) {
        if (name == null || !name.matches(EMPLOYEE_NAME_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_EMPLOYEE_NAME.getText());
        }
    }

    /**
     * 직원 직급 유효성 검사
     */
    public void isValidEmployeeRole(String role) {
        if (role == null || !role.matches(EMPLOYEE_ROLE_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_EMPLOYEE_ROLE.getText());
        }
    }

    /**
     * 직원 급여 유효성 검사
     */
    public void isValidEmployeeSalary(String salary) {
        if (salary == null || !salary.matches(EMPLOYEE_SALARY_REGEX)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_EMPLOYEE_SALARY.getText());
        }
    }


}
