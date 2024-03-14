package com.turing.api;

import com.turing.api.enums.NavigationOfFunction;
import com.turing.api.enums.NavigationOfPredicate;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Scanner sc = new Scanner(System.in);
//        String msg = NavigationOfFunction.selectMain(sc);
//        while (!NavigationOfFunction.selectMain(sc).equals("exit")) {

//        }
//        while(!NavigationOfConsumer.selctMain(sc).equals("exit")){
//
//        }
//        while(!NavigationOfSupplier.selctMain(sc).equals("exit")){
//
//        }
        while (NavigationOfPredicate.selectMain(sc)) {
//
//        }
        }
    }
}