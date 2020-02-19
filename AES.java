public class AES {

    private String secretKey;

    private String[] roundKeys = new String[10];


    public void createSession() {

        generateSecretKey();

        scheduleKey();
    }

    public void generateSecretKey() {

        secretKey = null;
    }

    private void scheduleKey() {

        for (int i = 0 ; i < 10 ; i++) {

            roundKeys[i] = null;
        }
    }


    public String encrypt(String plaintext) { 

        String encryptedMsgfromInitialRound = initialRound(plaintext);

        String encryptedMsgfromMainRound = mainRound(encryptedMsgfromInitialRound);

        String finalEncryptedMessage = finalRound(encryptedMsgfromMainRound);

        return finalEncryptedMessage;
    }

    private String initialRound(String plaintext) {

        return addRoundKey(plaintext, secretKey);
    }

    private String mainRound(String encryptedMsgfromInitialRound) {

        String roundData = encryptedMsgfromInitialRound;

        String subByteData, shiftRowsData, mixColumnData;

        for(int i = 0 ; i < 9 ; i++ ) {

            subByteData = subBytes(roundData);

            shiftRowsData = shiftRows(subByteData);

            mixColumnData = mixColumns(shiftRowsData);

            roundData = addRoundKey(mixColumnData, roundKeys[i]);

        }

        return roundData;
    }

    private String finalRound(String encryptedMsgfromMainRound) {

        String subByteData = subBytes(encryptedMsgfromMainRound);

        String shiftRowsData = shiftRows(subByteData);

        String finalData = addRoundKey(shiftRowsData, roundKeys[9]);

        return finalData;
    }

    private String subBytes(String state) { return null; }

    private String shiftRows(String state) { return null; }

    private String mixColumns(String state) { return null; }

    private String addRoundKey(String state, String roundKey) { 
        
        return null; 
    
    }

 



   public String decrypt(String message) { return null; }

    
}