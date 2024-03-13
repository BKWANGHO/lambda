package com.turing.api.account;


import com.turing.api.common.AbstractService;
import com.turing.api.enums.Messenger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountServiceImpl extends AbstractService<Account> implements AccountService {
    List<Account> accountList;
    List<Account> bankingHistory;
    String result = "";



    private static AccountServiceImpl instance = new AccountServiceImpl();

    private AccountServiceImpl() {
        this.accountList = new ArrayList<>();
        this.bankingHistory = new ArrayList<>();

    }
    public static AccountServiceImpl getInstance() {
        return instance;
    }


    @Override
    public String deposit(Account account) {
        for(Account Account : accountList){
            if (Account.getAccountNumber().equals(account.getAccountNumber())){
                Account.setBalance(Account.getBalance() + account.getBalance());
                result = "입금 성공! "+ account.getBalance() + "원 입금";
                bankingHistory.add(Account.builder()
                        .accountNumber(account.getAccountNumber())
                        .balance(account.getBalance())
                        .transactionDate(LocalDateTime.now())
                        .transation("입금 금액 : ")
                        .build());
            }else {
                result = "없는 계좌입니다.";
            }
        }
        return result;
    }

    @Override
    public String withdraw(Account account) {
        for(Account Account : accountList){
            if (Account.getAccountNumber().equals(account.getAccountNumber())){
                Account.setBalance(Account.getBalance() - account.getBalance());
                result = "출금 성공! "+ account.getBalance() + "원 출금";
                bankingHistory.add(Account.builder()
                        .accountNumber(account.getAccountNumber())
                        .balance(account.getBalance())
                        .transactionDate(LocalDateTime.now())
                        .transation("출금 금액 : ")
                        .build());
            }else {
                result = "없는 계좌입니다.";
            }
        }

        return result;
    }

    @Override
    public String getBalance(String accountNumber) {
        String balance = "";
        for (Account Account : bankingHistory)   {
            if (Account.getAccountNumber().equals(accountNumber)) {
                balance += Account.getTransation() + (Account.getBalance()+"\n");
            }else {
                balance = "없는 계좌입니다.";
            }
        }
        return balance;
    }


    @Override
    public Messenger save(Account account) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Account> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public Messenger delete(Account account) {
        return null;
    }


    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
