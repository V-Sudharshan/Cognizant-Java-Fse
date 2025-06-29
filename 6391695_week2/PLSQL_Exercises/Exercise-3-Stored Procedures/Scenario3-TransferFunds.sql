CREATE OR REPLACE PROCEDURE TransferFunds(
    from_acct IN NUMBER,
    to_acct IN NUMBER,
    amount IN NUMBER
) AS
    insufficient_balance EXCEPTION;
    from_balance NUMBER;
BEGIN
    SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_acct FOR UPDATE;
    IF from_balance < amount THEN
        RAISE insufficient_balance;
    END IF;
    UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = from_acct;
    UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = to_acct;
    COMMIT;
EXCEPTION
    WHEN insufficient_balance THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance.');
        ROLLBACK;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
        ROLLBACK;
END;
/
