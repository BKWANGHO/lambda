package menu;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Menu {
    private Long id;
    private String item;
    private String category;
}
