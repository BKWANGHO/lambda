package com.turing.api.board;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Board {
    private long id;
    private String boardName;
    private String boardType;

    @Builder(builderMethodName = "builder")
    public Board(long id, String boardName, String boardType) {
        this.id = id;
        this.boardName = boardName;
        this.boardType = boardType;

    }
}
