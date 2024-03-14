package com.turing.api.board;

public class BoardController {

    private static BoardController instance = new BoardController();
    private BoardService service;
    private BoardController() {
        this.service = BoardServiceImpl.getInstance();
    }

    public static BoardController getInstance() {
        return instance;
    }
}
