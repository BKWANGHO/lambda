package com.turing.api.board;

public class BoardRepository {
    private static BoardRepository instance = new BoardRepository();
    private BoardRepository() {
    }

    public static BoardRepository getInstance() {
        return instance;
    }
}
