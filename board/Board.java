package board;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Board {
    private long id;
    private String title;
    private String content;
    private String Writer;

    @Builder(builderMethodName = "builder")
    public Board(long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        Writer = writer;
    }
}
