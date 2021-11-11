package it.unibo.oop.lab.exception2;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */

public final class TestStrictBankAccount {
	private static final int INITIAL_BALANCE = 10000;
	private static final int FRACTION = INITIAL_BALANCE/12;
    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         */
    	 final AccountHolder firstUser = new AccountHolder("Primo", "Utente", 1);
         final AccountHolder secondUser = new AccountHolder("Secondo", "Utente", 2);
         final StrictBankAccount firstUserAccount = new StrictBankAccount(firstUser.getUserID(), INITIAL_BALANCE, 0);
         final StrictBankAccount secondUserAccount = new StrictBankAccount(secondUser.getUserID() ,INITIAL_BALANCE ,1 );
    	/*
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	try {
    		firstUserAccount.deposit(secondUser.getUserID(), INITIAL_BALANCE);
    		Assert.fail("Should have thrown WrongAccountHolderException.");
    	}catch(WrongAccountHolderException e) {
    		Assert.assertNotNull(e);
    	}
    	try {
    		secondUserAccount.withdraw(secondUser.getUserID(), INITIAL_BALANCE + INITIAL_BALANCE);	    		
        	Assert.fail("Should have thrown NotEnoughFoundsException.");
    	}catch(NotEnoughFoundsException e) {
    		Assert.assertNotNull(e);	
    	}
    	firstUserAccount.withdrawFromATM(firstUser.getUserID(), FRACTION);	
		try {
    		firstUserAccount.withdrawFromATM(firstUser.getUserID(), FRACTION);	    		
        	Assert.fail("Should have thrown TransactionsOverQuotaException.");
    	}catch(TransactionsOverQuotaException e) {
    		Assert.assertNotNull(e);	
    	}

	
    }
}
