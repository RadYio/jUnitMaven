package monappli.mvn;


import static org.junit.Assert.*;
import java.util.stream.IntStream;
import org.junit.jupiter.api.*;




/**
 * Unit test for simple App.
 */
public class DequeTest 
{
    public static Deque maDeque;
    public static IntStream stream;

    @BeforeAll
    @DisplayName("Initialisation de mes tests")
    public static void initQueue(){
        maDeque = new Deque();
    }

    @BeforeEach
    @DisplayName("Reset de la deque")
    public void reset(){
        maDeque.viderDeque();
        stream = IntStream
                .generate(() -> { return (int)(Math.random() * 10000); });
    }

    @AfterEach
    public void afficheOK(TestInfo testInfo){
        System.out.print("┏");
        for(int i = 0; i < testInfo.getDisplayName().length() + 9; i++) System.out.print("━");
        System.out.println("┓");
        System.out.println("┃ \u001B[47m\u001B[30m" + testInfo.getDisplayName() + " -->\u001B[0m\u001B[32m OK\u001B[0m ┃");
        System.out.print("┗");
        for(int i = 0; i < testInfo.getDisplayName().length() + 9; i++) System.out.print("━");
        System.out.println("┛");
    }

    @Test
    @DisplayName("ajouterTeteOterTeteNValeurs")
    public void ajouterTeteOterTeteNValeurs(){
        int nbElem = 20;
        stream.limit(nbElem).forEach(maDeque::ajouterTete);
        assertFalse(maDeque.estVide());

        //on compte le nombre d'éléments
        int nbElemDeque;
        for(nbElemDeque = 0; !maDeque.estVide(); nbElemDeque++){
            maDeque.oterTete();
        }

        assertTrue(maDeque.estVide());
        assertEquals(nbElem, nbElemDeque);
    }
    
    @Test
    @DisplayName("ajouterTeteOterTeteUneValeur")
    public void ajouterTeteOterTeteUneValeur(){
        int nbElem = 1;
        stream.limit(nbElem).forEach(maDeque::ajouterTete);
        assertFalse(maDeque.estVide());
        maDeque.oterTete();
        assertTrue(maDeque.estVide());
    }

    @Test
    @DisplayName("ajouterTeteOterTeteDeuxValeurs")
    public void ajouterTeteOterTeteDeuxValeurs(){
        int nbElem = 2;
        stream.limit(nbElem).forEach(maDeque::ajouterTete);
        assertFalse(maDeque.estVide());
        maDeque.oterTete();
        assertFalse(maDeque.estVide());
        maDeque.oterTete();
        assertTrue(maDeque.estVide());

    }


    //=============
    //=== QUEUE ===
    //=============


    @Test
    @DisplayName("ajouterQueueOterQueueNValeurs")
    public void ajouterQueueOterQueueNValeurs(){
        int nbElem = 20;
        stream.limit(nbElem).forEach(maDeque::ajouterQueue);
        assertFalse(maDeque.estVide());

        //on compte le nombre d'éléments
        int nbElemDeque;
        for(nbElemDeque = 0; !maDeque.estVide(); nbElemDeque++){
            maDeque.oterQueue();
        }
        assertEquals(nbElem, nbElemDeque);
        assertTrue(maDeque.estVide());
    }

    @Test
    @DisplayName("ajouterQueueOterQueueUneValeur")
    public void ajouterQueueOterQueueUneValeur(){
        int nbElem = 1;
        stream.limit(nbElem).forEach(maDeque::ajouterQueue);
        assertFalse(maDeque.estVide());
        maDeque.oterQueue();
        assertTrue(maDeque.estVide());
    }

    @Test
    @DisplayName("ajouterQueueOterQueueDeuxValeurs")
    public void ajouterQueueOterQueueDeuxValeurs(){
        int nbElem = 2;
        stream.limit(nbElem).forEach(maDeque::ajouterQueue);
        assertFalse(maDeque.estVide());
        maDeque.oterQueue();
        assertFalse(maDeque.estVide());
        maDeque.oterQueue();
        assertTrue(maDeque.estVide());
    }

    @Test
    @DisplayName("oterTeteDequeVide")
    public void oterTeteDequeVide(){
        assertTrue(maDeque.estVide());
        //On verifie que l'exception est bien levée
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            maDeque.oterTete();
        });
        assertTrue(maDeque.estVide());
    }

    @Test
    @DisplayName("oterQueueDequeVide")
    public void oterQueueDequeVide(){
        assertTrue(maDeque.estVide());
        //On verifie que l'exception est bien levée
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            maDeque.oterQueue();
        });
        assertTrue(maDeque.estVide());
    }

    @Test
    @DisplayName("ajouterTeteOterQueueNValeurs")
    public void ajouterTeteOterQueueNValeurs(){
        int nbElem = 20;
        stream.limit(nbElem).forEach(maDeque::ajouterTete);
        assertFalse(maDeque.estVide());

        //on compte le nombre d'éléments
        int nbElemDeque;
        for(nbElemDeque = 0; !maDeque.estVide(); nbElemDeque++){
            maDeque.oterQueue();
        }
        assertEquals(nbElem, nbElemDeque);
        assertTrue(maDeque.estVide());
    }

    @Test
    @DisplayName("ajouterQueueOterTeteNValeurs")
    public void ajouterQueueOterTeteNValeurs(){
        int nbElem = 20;
        stream.limit(nbElem).forEach(maDeque::ajouterQueue);
        assertFalse(maDeque.estVide());

        //on compte le nombre d'éléments
        int nbElemDeque;
        for(nbElemDeque = 0; !maDeque.estVide(); nbElemDeque++){
            maDeque.oterTete();
        }
        assertEquals(nbElem, nbElemDeque);
        assertTrue(maDeque.estVide());
    }



}