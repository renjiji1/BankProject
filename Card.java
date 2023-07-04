package mainTest;

//Matt Esposito and Arav Goyal
public class Card {
  private String CardNumber;
  private String CardExpirationDate;
  private String CardHolderName;
  private String CardCVV;
  private int CardAnnualFee;
  private String CardDateOpened;
  private double CardWithdrawalFee;
  private double CardTransactionFee;
  private boolean isCardActive;

  public Card() //default constructor
  {
      CardNumber = "0000000000000000";
      CardExpirationDate = "00/00";
      CardHolderName = "john doe";
      CardCVV = "000";
      CardAnnualFee = 0;
      CardDateOpened = "00/00/0000";
      CardWithdrawalFee = 0;
      CardTransactionFee = 0;
      isCardActive = false;
  }

  //private variables all have Card and are capitalized, all the parameters are lowercase without Card (except for CVV)

  public Card(String number, String expirationDate, String holderName, String CVV, int annualFee, String dateOpened, double withdrawalFee, double transactionFee, boolean isActive)
  { //overloaded constructor
      CardNumber = number;
      CardExpirationDate = expirationDate;
      CardHolderName = holderName;
      CardCVV = CVV;
      CardAnnualFee = annualFee;
      CardDateOpened = dateOpened;
      CardWithdrawalFee = withdrawalFee;
      CardTransactionFee = transactionFee;
      isCardActive = isActive;
  }

  //get and set methods
  public void setNumber(String number)
  {
      CardNumber = number;
  }

  public String getNumber()
  {
      return CardNumber;
  }

  public void setExpirationDate(String expirationDate)
  {
      CardExpirationDate = expirationDate;
  }

  public String getExpirationDate()
  {
      return CardExpirationDate;
  }

  public void setHolderName(String holderName)
  {
      CardHolderName = holderName;
  }

  public String getHolderName()
  {
      return CardHolderName;
  }

  public void setCVV(String CVV)
  {
      CardCVV = CVV;
  }

  public String getCVV()
  {
      return CardCVV;
  }

  public void setAnnualFee(int annualFee)
  {
      CardAnnualFee = annualFee;
  }

  public int getAnnualFee()
  {
      return CardAnnualFee;
  }

  public void setDateOpened(String dateOpened)
  {
      CardDateOpened = dateOpened;
  }

  public String getDateOpened()
  {
      return CardDateOpened;
  }

  public void setWithdrawalFee(double withdrawalFee)
  {
      CardWithdrawalFee = withdrawalFee;
  }

  public double getWithdrawalFee()
  {
      return CardWithdrawalFee;
  }

  public void setTransactionFee(double transactionFee)
  {
      CardTransactionFee = transactionFee;
  }

  public double getTransactionFee()
  {
      return CardTransactionFee;
  }

  public void cancelCard()
  {
      isCardActive = false;
  }

  public boolean getCardActive()
  {
      return isCardActive;
  }
}