package com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount;

import com.dio.challenge.lab_banco_digital_oo.interfaces.IAccount;
import com.dio.challenge.lab_banco_digital_oo.model.entities.business.Bank;
import com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount.Account;
import com.dio.challenge.lab_banco_digital_oo.model.reference.ClientBankPersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AccountDTO implements IAccount {

    private Long id;

    private ClientBankPersist client;

    private String typeAccount;

    private String agency;

    private String numberAccount;

    private Double balance;

    public static <T extends AccountDTO> T convertTypeAccountDTO( T accountDTO, Account account){
         accountDTO.setId(accountDTO.getId());
         accountDTO.setClient(account.getClient());
         accountDTO.setTypeAccount(account.getTypeAccount());
         accountDTO.setAgency(account.getAgency());
         accountDTO.setNumberAccount(account.getNumberAccount());
         accountDTO.setBalance(account.getBalance());
         return accountDTO;
    }

    @Override
    public void withdraw(Double valueToWithdraw) {
        Bank.checkBalanceAccountToWithdraw(this, valueToWithdraw);
        setBalance(getBalance() - valueToWithdraw);
    }

    @Override
    public void deposit(Double valueToDeposit) {

    }

    @Override
    public void transferToAnotherAccount(Double amountToTransfer, AccountDTO targetAccount) {

    }
//    private AccountDTO(Builder builder) {
//        this.id = builder.id;
//        this.client = builder.client;
//        this.typeAccount = builder.typeAccount;
//        this.agency = builder.agency;
//        this.numberAccount = builder.numberAccount;
//        this.balance = builder.balance;
//    }

//    AccountDTO(Account account){
//        this.id = account.getId();
//        this.client = account.getClient();
//        this.typeAccount = account.getTypeAccount();
//        this.agency = account.getAgency();
//        this.numberAccount = account.getNumberAccount();
//        this.balance = account.getBalance();
//    }

//    public abstract static class Builder {
//        private Long id;
//        private ClientBankPersist client;
//        private String typeAccount;
//        private String agency;
//        private String numberAccount;
//        private Double balance;
//
//        public Builder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder client(ClientBankPersist client) {
//            this.client = client;
//            return this;
//        }
//
//        public Builder typeAccount(String typeAccount) {
//            this.typeAccount = typeAccount;
//            return this;
//        }
//
//        public Builder agency(String agency) {
//            this.agency = agency;
//            return this;
//        }
//
//        public Builder numberAccount(String numberAccount) {
//            this.numberAccount = numberAccount;
//            return this;
//        }
//
//        public Builder balance(Double balance) {
//            this.balance = balance;
//            return this;
//        }
//
//        public <T extends AccountDTO> T build() {
//            return new T(this);
//        }
//    }

//    public static AccountDTO from(Account account) {
//        return new AccountDTO.Builder()
//        .id(account.getId())
//        .client(account.getClient()) // Supondo que o método getClient() retorne um ClientePersist
//        .typeAccount(account.getTypeAccount())
//        .agency(account.getAgency())
//        .numberAccount(account.getNumberAccount())
//        .balance(account.getBalance())
//        .build();
//    }


}

