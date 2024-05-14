package it.corso.esercizioNegozioAlimentare;

import java.util.ArrayList;

public class GestoreScorte {
    private ArrayList<Prodotto> inventario = new ArrayList<>();

    public void aggiungiProdotto(Prodotto prodotto) {
        inventario.add(prodotto);
    }

    public void modificaQuantitaProdotto(int codice, int nuovaQuantita) {
        for (Prodotto prodotto : inventario) {
            if (prodotto.getCodice() == codice) {
                prodotto.setQuantitaDisponibile(nuovaQuantita); 
                break;
            }
        }
    }

    public void visualizzaInventario() {
        for (Prodotto prodotto : inventario) {
            System.out.println("Codice: " + prodotto.getCodice() + ", Descrizione: " + prodotto.getDescrizione() +
                    ", Quantità: " + prodotto.getQuantitaDisponibile() + ", Prezzo: " + prodotto.getPrezzoUnitario());
        }
    }

    public void rimuoviProdotto(int codice) {
        inventario.removeIf(prodotto -> prodotto.getCodice() == codice);
    }

    public static void main(String[] args) {
        GestoreScorte gestore = new GestoreScorte();

        gestore.aggiungiProdotto(new ProdottoAlimentare(1, "Latte", 100, 1.50, "2022-02-28"));
        gestore.aggiungiProdotto(new ProdottoElettronico(2, "Smartphone", 50, 499.99, 12));

        gestore.visualizzaInventario();

        gestore.modificaQuantitaProdotto(1, 80);

        System.out.println("Dopo la modifica:");
        gestore.visualizzaInventario();

        gestore.rimuoviProdotto(2);

        System.out.println("Dopo la rimozione:");
        gestore.visualizzaInventario();
    }
}
