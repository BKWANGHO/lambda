package com.turing.api.board;

public class BoardServiceImpl implements BoardService {

    private static BoardService instance = new BoardServiceImpl();
    private BoardRepository repository;
    private BoardServiceImpl() {
        this.repository = BoardRepository.getInstance();
    }

    public static BoardService getInstance() {
        return instance;
    }



}
