package com.turing.api;

import com.turing.api.enums.Messenger;
import com.turing.api.enums.NavigationOfPredicate;
import menu.Menu;
import menu.MenuController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
//        MenuController.getInstance().createMenus();
//        MenuController.getInstance().insertMenus();
//        MenuController.getInstance().deleteMenus();
//        Messenger msg = MenuController.getInstance().returnMessenger();
//        Menu onemenu = MenuController.getInstance().returnOneMenu();
//        MenuController.getInstance().returnAllMenus().forEach(i-> System.out.print(((Menu)i).getItem() + "  "));
//        System.out.println();
//        MenuController.getInstance().returnAllMenus().forEach(System.out::println);

        Scanner sc = new Scanner(System.in);
//        String msg = NavigationOfFunction.selectMain(sc);
//        while (!NavigationOfFunction.selectMain(sc).equals("exit")) {

//        }
//        while(!NavigationOfConsumer.selctMain(sc).equals("exit")){
//
//        }
////        while(!NavigationOfSupplier.selctMain(sc).equals("exit")){
////
////        }
        while (NavigationOfPredicate.selectMain(sc)) {

        }
    }
}