package menu;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Menu {
    private Long id;
    private String item;
    private String category;
}
