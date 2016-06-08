import com.paytm.iface.Queue;
import com.paytm.impl.ImmutableQueue;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

/**
 * Created by Sunil on 6/7/2016.
 */
public class ImmutableQueueTests {

    // It's just a sanity test
    public static void main(String[] args) {
        Queue<String> q = new ImmutableQueue();
        q = q.enQueue("1");
        q = q.enQueue("2");
        q = q.enQueue("3");
        q = q.enQueue("4");
        q = q.enQueue("5");

        //Should be false
        System.out.println("Is queue empty : " + q.isEmpty());

        //Should print in FIFO order
        System.out.println(q.head());
        q = q.deQueue();
        System.out.println(q.head());
        q = q.deQueue();
        System.out.println(q.head());
        q = q.deQueue();
        System.out.println(q.head());
        q = q.deQueue();
        System.out.println(q.head());
        q = q.deQueue();

        //Should be true
        System.out.println("Is queue empty : " + q.isEmpty());
    }
}
