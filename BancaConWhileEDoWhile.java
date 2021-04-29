package main;

import java.util.Scanner;

public class BancaConWhileEDoWhile {

	public static void main(String[] args) {
		/*
		 Programma banca on-line ...versione con PIN
		 Partendo da un bilancio (capitale) di 15.000 €
		 creare un menu da permettere al correntista di fare le seguenti operazioni
		 1- digitazione del PIN di 4 cifre - max 3 tentativi
		 2- bilancio 
		  - deposito
		  - ritiro denaro
		  - storico operazioni
		  - chiusura programma
		  BONUS permettere all'utente di poter effettuare altre operazioni, finchè non vorrà
		  uscire dal programma.
		 */
		
		Scanner tastiera = new Scanner(System.in);

		int bilancio = 15000;
		String storico = "";
		String cmd;
		String ris = "";
		int tentativi = 3;
		String PIN = "0123";
		String PINinserito;
		String legenda = "\t Indicare l'operazione: \n"         +
							"1 - Bilancio \n" 					+
							"2 - Deposito \n" 					+
							"3 - Prelievo \n" 					+
							"4 - Storico \n" 					+
							"5 - Esci \n"                       +
							"6 - Legenda";
		
		do {
			System.out.println("Perfavore digita il PIN, hai" + tentativi + " tentativi");
			PINinserito = tastiera.nextLine();
			if (PINinserito.equals(PIN)) {
				System.out.println("Hai fatto il login correttamente");
				break;	
			}
			else
				tentativi --;
		}while(tentativi > 0);
		
		if(tentativi == 0) {
			System.out.println("Mi dispiace, hai raggiunto il massimo di tentativi, il programma verrà terminato");
			// Forza l'interruzione del programma
			System.exit(-1);
		}
		
		System.out.println(legenda);
		do {
			cmd = tastiera.nextLine();

			switch (cmd) {

			case "1":
				ris = "Il tuo bilancio è di " + bilancio + " €";
				break;

			case "2":
				System.out.println("Quanto vuoi depositare ?");
				int daDepositare = Integer.parseInt(tastiera.nextLine());

				if(daDepositare > 0) {
					bilancio += daDepositare;
					storico += " \nDepositato: " + daDepositare + " €";
					ris = "Hai depositato " + daDepositare + " €";
				} else 
					ris = "Opss.... non hai nulla da depositare ??";				
				break;

			case "3":
				System.out.println("Quanto vuoi prelevare ?");
				int daPrelevare = Integer.parseInt(tastiera.nextLine());

				if(daPrelevare > 0 && daPrelevare <= bilancio) {
					bilancio -= daPrelevare;
					storico += " \nPrelevato: " + daPrelevare + " €";
					ris = "Hai prelevato: " + daPrelevare + " €";
					break;
				} 
				else {
					System.out.println("Prelievo non valido.");
					break;
				}

			case "4":
				// controlla se la stringa è vuota --> restituirà true o false
				if(storico.isEmpty())
					ris = "Non hai ancora effettuato nessuna operazione..";
				else
					ris = "Il tuo storico è: " + storico;
				break;

			case "5":
				ris = "Arrivederci..... è stato un piacere";
				break;
			
			case "6":
				ris = legenda;
				break;

			default:
				ris = "Comando non riconosciuto ....!!!";
			}

			System.out.println(ris);

		} while (!cmd.equals("5"));

		tastiera.close();

	}

}
