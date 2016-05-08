import com.bytebreak.tictactoe.State;
import org.junit.Assert;
import org.junit.Test;

public class StateTest {

    @Test
    public void testStateSerialization(){
        State a = new State();
        a.q = -1;
        a.a = -1;
        a.z = -1;
        a.e = 1;
        a.w = 1;
        a.finished = true;
        a.winner = -1;
        String aStr = a.serialize();
        System.out.println(aStr);
        State b = new State();
        b.deserialize(aStr);
        String bStr = b.serialize();
        Assert.assertEquals(aStr, bStr);
    }
}
