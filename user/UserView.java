package user;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner sc) throws SQLException {
        UserController ctrl =new UserController();
        ctrl.addUsers();

        while (true) {
            System.out.println("[메뉴] 0-종료\n " +
                    "1-회원가입\n" + //o
                    "2-로그인\n " + //o
                    "3-ID검색\n " +
                    "4-비번변경\n " + // 0
                    "5-탈퇴\n " +  //0
                    "ls-회원목록\n " + //0
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수\n" +
                    "touch-테이블 생성\n" +
                    "rm-테이블 삭제");   // 0
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("=== 회원가입 ===");
                    System.out.println("ID,비밀번호," +
                            "이름,전화번호,직업," +
                            "키,몸무게를 입력해주세요");
                    System.out.println(ctrl.join(sc));
                    break;

                case "2":
                    System.out.println("=== 로그인 ===");
                    System.out.println("아이디를 입력해주세요");
                    System.out.println("비밀번호를 입력해주세요");
                    System.out.println(ctrl.login(sc));
                    break;

                case "3":
                    System.out.println("=== ID검색 ===");
                    System.out.println("아이디를 입력하세요");
//                    System.out.println(ctrl.getOne(sc));
                    System.out.println(ctrl.getUser(sc));
                    break;

                case "4":
                    System.out.println("아이디를 입력하세요");
                    System.out.println("변경할 비밀번호 입력하세요");
                    System.out.println("한번더 입력하세요");
                    System.out.println(ctrl.updatePassword(sc));
                    break;

                case "5":
                    System.out.println("탈퇴할 아이디를 입력하세요");
                    System.out.println(ctrl.deleteUser(sc));
                    break;

                case "ls":
                    System.out.println("=== 회원목록 ===");
                    ctrl.findUsers().forEach(System.out::println);
                    break;

                case "7":
                    System.out.println("=== 이름으로검색 ===");
                    System.out.println("이름을 입력하세요");
                    System.out.println(ctrl.findUserByName(sc));
                    break;

                case "8":
                    System.out.println("=== 직업검색 ===");
                    System.out.println("직업을 입력하세요");
                    System.out.println(ctrl.findUserByJob(sc));
                    break;

                case "9":
                    System.out.println("=== 회원수 ===");
                    System.out.println(ctrl.countUser());
                    break;

                case "touch":
                    System.out.println("=== 테이블 생성  ===");
                    System.out.println(ctrl.touchTable());
                    break;

                case "rm":
                    System.out.println("=== 테이블 생성  ===");
                    System.out.println(ctrl.removeTable());
                    break;
            }
        }
    }
}
