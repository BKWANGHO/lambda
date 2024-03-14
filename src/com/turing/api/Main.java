package com.turing.api;

import com.turing.api.enums.NavigationOfConsumer;
import com.turing.api.enums.NavigationOfFunction;
import com.turing.api.enums.NavigationOfPredicate;
import com.turing.api.enums.NavigationOfSupplier;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Scanner sc = new Scanner(System.in);

        while (!NavigationOfFunction.selctMain(sc).equals("exit")) {

        }
//        while(!NavigationOfConsumer.selctMain(sc).equals("exit")){
//
//        }
//        while(!NavigationOfSupplier.selctMain(sc).equals("exit")){
//
//        }
//        while (NavigationOfPredicate.selectMain(sc)) {
//
//        }
    }
}