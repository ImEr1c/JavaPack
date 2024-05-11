import com.imer1c.api.annotation.EventClass;
import com.imer1c.api.annotation.EventListener;
import com.imer1c.api.events.EventType;

@EventClass
public class Eventus {

    @EventListener(EventType.TICK)
    public void tick()
    {

    }

    @EventListener(EventType.SETUP)
    public void setup()
    {

    }
}
