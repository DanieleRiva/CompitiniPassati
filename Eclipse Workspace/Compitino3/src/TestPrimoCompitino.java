import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestPrimoCompitino {


	// **********************************    Test su Piatto
	// Creazione
	@Test
	public void testPiattoCreazione1() {
		Piatto piatto = new Piatto("Pollo arrosto", Piatto.SECONDO, 20);
		assertEquals(new String("Pollo arrosto"), piatto.getNome());
		assertEquals(Piatto.SECONDO, piatto.getTipo());	
		assertEquals(20, piatto.getCosto());
	}

	//equals
	@Test
	public void testPiattoEquals1() {
		Piatto piatto1 = new Piatto("Spaghetti", Piatto.PRIMO, 20);
		Piatto piatto2 = new Piatto("Spaghetti", Piatto.PRIMO, 20);
		assertTrue(piatto1.equals(piatto2));
	}

	@Test
	public void testPiattoEquals2() {
		Piatto piatto1 = new Piatto("Spaghetti", Piatto.PRIMO, 20);
		Piatto piatto2 = new Piatto(new String("Spaghetti"), Piatto.PRIMO, 20);
		assertTrue(piatto1.equals(piatto2));			
	}

	@Test
	public void testPiattoEquals3() {
		Piatto piatto1 = new Piatto("Spaghetti", Piatto.PRIMO, 20);
		Piatto piatto2 = new Piatto("Spaghetti", Piatto.PRIMO, 30);
		assertTrue(piatto1.equals(piatto2));			
	}	

	@Test
	public void testPiattoEquals4() {
		Piatto piatto1 = new Piatto("Spaghetti", Piatto.PRIMO, 20);
		Piatto piatto2 = new Piatto("Spaghetti", Piatto.DOLCE, 20);
		assertFalse(piatto1.equals(piatto2));			
	}	

	@Test
	public void testPiattoEquals5() {
		Piatto piatto1 = new Piatto("Spaghetti", Piatto.PRIMO, 20);
		Piatto piatto2 = new Piatto("Pollo arrosto", Piatto.SECONDO, 30);
		assertFalse(piatto1.equals(piatto2));			
	}

	@Test
	public void testPiattoEquals6() {
		Piatto piatto1 = new Piatto("Spaghetti", Piatto.PRIMO, 20);
		Piatto piatto2 = new Piatto("spaghetti", Piatto.PRIMO, 20);
		assertTrue(piatto1.equals(piatto2));			
	}	
	// **********************************    Test su Menu
	// Creazione
	@Test
	public void testCreazioneMenu() {
		Menu menu = new Menu(4);
		assertEquals(4, menu.dimensioneMenu());

		menu = new Menu(0);
		assertEquals(5, menu.dimensioneMenu());

		menu = new Menu(1);
		assertEquals(1, menu.dimensioneMenu());

		menu = new Menu(5);
		assertEquals(5, menu.dimensioneMenu());

		menu = new Menu(6);
		assertEquals(5, menu.dimensioneMenu());

		menu = new Menu();
		assertEquals(5, menu.dimensioneMenu());
	}

	// Aggiungi
	@Test
	public void testAggiungiPiatto() {
		Menu menu = new Menu(3);
		boolean esito = menu.aggiungiPiatto(new Piatto("Spaghetti", Piatto.PRIMO, 20));
		assertTrue(esito);

		esito = menu.aggiungiPiatto(null);
		assertFalse(esito);

		esito = menu.aggiungiPiatto(new Piatto("Ravioli", Piatto.PRIMO, 20));
		assertFalse(esito);

		esito = menu.aggiungiPiatto(new Piatto("Spaghetti", Piatto.DOLCE, 10));
		assertTrue(esito);

		esito = menu.aggiungiPiatto(new Piatto("Patatine", Piatto.CONTORNO, 10));
		assertTrue(esito);

		//ho saturato il menu
		esito = menu.aggiungiPiatto(new Piatto("Pollo arrosto", Piatto.SECONDO, 20));
		assertFalse(esito);

	}

	//Rimuovi
	@Test
	public void testRimuoviPiatto() {
		Menu menu = new Menu(3);
		menu.aggiungiPiatto(new Piatto("Spaghetti", Piatto.PRIMO, 20));
		menu.aggiungiPiatto(new Piatto("Patatine", Piatto.CONTORNO, 10));
		menu.aggiungiPiatto(new Piatto("Pollo arrosto", Piatto.SECONDO, 20));

		boolean esito = menu.rimuoviPiatto(new Piatto("Patatine", Piatto.CONTORNO, 10));
		assertTrue(esito);

		esito = menu.rimuoviPiatto(new Piatto("Pollo arrosto", Piatto.SECONDO, 10));
		assertTrue(esito);

		esito = menu.rimuoviPiatto(new Piatto("Polpette", Piatto.SECONDO, 10));
		assertFalse(esito);
	}

	//Rimuovi
	@Test
	public void testSostituisciPiatto() {
		Menu menu = new Menu(3);
		menu.aggiungiPiatto(new Piatto("Patatine", Piatto.CONTORNO, 10));
		menu.aggiungiPiatto(new Piatto("Pollo arrosto", Piatto.SECONDO, 20));
		menu.aggiungiPiatto(new Piatto("Ravioli", Piatto.PRIMO, 10));
		boolean esito = menu.sostituisciPiatto(null);
		assertFalse(esito);
		esito = menu.sostituisciPiatto(new Piatto("Gelato", Piatto.DOLCE, 10));
		assertFalse(esito);
		esito = menu.sostituisciPiatto(new Piatto("Ravioli", Piatto.PRIMO, 10));
		assertTrue(esito);
	}

	//tipo piatto
	@Test
	public void testTipoPiattoPresente() {
		Menu menu = new Menu(3);
		menu.aggiungiPiatto(new Piatto("Spaghetti", Piatto.PRIMO, 20));
		menu.aggiungiPiatto(new Piatto("Patatine", Piatto.CONTORNO, 10));
		menu.aggiungiPiatto(new Piatto("Pollo arrosto", Piatto.SECONDO, 20));

		assertEquals(-1, menu.tipoPiattoPresente(Piatto.ANTIPASTO));
		assertEquals(0, menu.tipoPiattoPresente(Piatto.PRIMO));
		assertEquals(2, menu.tipoPiattoPresente(Piatto.SECONDO));
		assertEquals(1, menu.tipoPiattoPresente(Piatto.CONTORNO));
		assertEquals(-1, menu.tipoPiattoPresente(Piatto.DOLCE));
	}

	//calcola costo
	@Test
	public void testCosto() {
		Menu menu = new Menu(4);
		menu.aggiungiPiatto(new Piatto("Spaghetti", Piatto.PRIMO, 20));
		menu.aggiungiPiatto(new Piatto("Patatine", Piatto.CONTORNO, 10));
		menu.aggiungiPiatto(new Piatto("Pollo arrosto", Piatto.SECONDO, 20));
		menu.aggiungiPiatto(new Piatto("Gelato", Piatto.DOLCE, 10));
		assertEquals(60,menu.calcolaCosto());
		menu.rimuoviPiatto(new Piatto("Patatine", Piatto.CONTORNO, 10));
		assertEquals(50,menu.calcolaCosto());
	}
}
