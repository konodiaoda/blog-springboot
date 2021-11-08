import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-31 11:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdentityCard {
    private String num;
}
