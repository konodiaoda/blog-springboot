import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wujiahui
 * @description
 * @date 2021-10-31 11:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private String brith;
    private IdentityCard identityCard;
    private String sex;
}
