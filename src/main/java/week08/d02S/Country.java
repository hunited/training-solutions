package week08.d02S;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    private String country;
    private int population;
    private int numberOfFlagColors;
    private int neighbourhood;

}
