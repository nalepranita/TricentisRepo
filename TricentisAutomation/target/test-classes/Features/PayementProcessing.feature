Feature: Test the functionality Payement of product

  @Payment_Flow
  Scenario Outline: As a user, I should be able make the payment products after checkout
    Given User should be in Payment Method section
    When User Enter Payment Information "<paymentType>","<cardType>","<cardHolderName>","<cardNumber>","<expirationMonth>","<expirationYear>","<cardCode>","<PO_Number>"
    Then Review Order and Click Confirm Order "<product>"

    Examples: 
      | paymentType    | cardHolderName |cardType    | cardNumber   | expirationMonth | expirationYear  |cardCode|PO_Number|product									 |
      | Credit Card    | Jane Doe       |Visa        | 123412341234 | 01              |      123456     | 233    |1234455  |Computing and Internet   | 
      | Purchase Order | Sane Doe       |Master Card | 234512345234 | 02              |      456778     | 344    |2344657  |Create Your Own Jewelry  | 
