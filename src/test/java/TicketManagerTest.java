import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketManagerTest {

    @Test
    public void sortTicketTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NSK", 8_354, 12, 13);
        Ticket ticket2 = new Ticket("MSK", "SPB", 65_464, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "NSK", 6_545, 14, 11);
        Ticket ticket4 = new Ticket("MSK", "OMSK", 841, 12, 12);
        Ticket ticket5 = new Ticket("MSK", "NSK", 333, 15, 17);
        Ticket ticket6 = new Ticket("MSK", "NSK", 3_215, 17, 15);
        Ticket ticket7 = new Ticket("MSK", "KRS", 354, 16, 16);
        Ticket ticket8 = new Ticket("MSK", "NSK", 528_354, 10, 18);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "NSK");
        Ticket[] expected = {ticket5, ticket6, ticket3, ticket1, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketComparatorTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "NSK", 200, 12, 14);//2
        Ticket ticket2 = new Ticket("MSK", "SPB", 65_464, 13, 15);
        Ticket ticket3 = new Ticket("MSK", "NSK", 100, 14, 17);//3
        Ticket ticket4 = new Ticket("MSK", "OMSK", 841, 12, 12);
        Ticket ticket5 = new Ticket("MSK", "NSK", 400, 7, 17);//10
        Ticket ticket6 = new Ticket("MSK", "NSK", 200, 17, 21);//4
        Ticket ticket7 = new Ticket("MSK", "KRS", 354, 16, 16);
        Ticket ticket8 = new Ticket("MSK", "NSK", 500, 10, 11);//1
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "NSK", comparator);
        Ticket[] expected = {ticket6, ticket3, ticket1, ticket8, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }
}
