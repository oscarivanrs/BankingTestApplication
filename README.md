# BankingTestApplication
Dopo l'avvio l'applicazione ascolta sulla porta 8080
aprendo la pagina del browser ci sarà la posibilità di tre operazioni:
* Visualizzare saldo.
* Visualizzare transazioni di un arco temporale.(ed inserirle su un database)
* Effettuare una transazione.

Moduli:
./com/test/account/banking/api/BalanceController.java
showSaldo(): Questo modulo si collega all'api di fabrick per interrogare il saldo di un prefissato account.

./com/test/account/banking/api/TransactionsController.java
listTransactions: Questo modulo si collega all'api di fabrick per lo storico transazioni dato un range temporale di input di un prefissato account.
saveTransactions: Esegue la insert in un database dello storico precedentemente scaricato.

./com/test/account/banking/api/TransferController.java
doTransfer: Cerca di eseguire una transazione con dei dati fittizi, recupera come input solo l'importo e il codice beneficiario.

com/test/account/banking/model
In questo pacchetto ci sono tutti gli oggetti usati come modelli per le risposte delle api.
