package banking_system;

public class Transaction {
   private String date;
   private String transactionNo;
   private String type;
   private int amount;
   private String receiver;
   private String sender;
   private String code;

   public Transaction(int transactionId, String transactionType, double transactionAmount, String transactionDate,
         String transactionRid, String transactionSid, String transactionCode) {
      this.transactionNo = String.valueOf(transactionId);
      this.type = transactionType;
      this.amount = (int) transactionAmount; // Convert double to int
      this.date = transactionDate;
      this.receiver = transactionRid;
      this.sender = transactionSid;// Assuming receiver_id is the receiver
      this.code = transactionCode;
      // Assuming no other fields need to be initialized
   }

   public String getDate() {
      return date;
   }

   public String getTransactionNo() {
      return transactionNo;
   }

   public String getType() {
      return type;
   }

   public int getAmount() {
      return amount;
   }

   public String getReceiver() {
      return receiver;
   }

   public String getSender() {
      return sender;
   }

   public String getCode() {
      return code;
   }
}
