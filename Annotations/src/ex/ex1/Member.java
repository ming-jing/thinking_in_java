package ex.ex1;

/**
 * Created by belows on 2017/1/3.
 */
@DBTable(name="Member")
public class Member {
    @SQLInt(name="id")
    int id = 3;
    @SQLString(name="name",length = 30)
    String name;
    @Deprecated
    @SQLString(name="handler", length = 30)
    String handler;

}
