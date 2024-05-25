package com.dio.challenge.lab_banco_digital_oo.service;

import com.dio.challenge.lab_banco_digital_oo.exception.exceptions.*;
import com.dio.challenge.lab_banco_digital_oo.model.dto.typeAccount.AccountDTO;
import com.dio.challenge.lab_banco_digital_oo.model.entities.business.Bank;
import com.dio.challenge.lab_banco_digital_oo.model.entities.typeAccount.Account;
import com.dio.challenge.lab_banco_digital_oo.model.entities.users.ClientBank;
import com.dio.challenge.lab_banco_digital_oo.model.requests.AccountRequest;
import com.dio.challenge.lab_banco_digital_oo.model.requests.AccountRequestToUpdate;
import com.dio.challenge.lab_banco_digital_oo.model.responses.AccountResponse;
import com.dio.challenge.lab_banco_digital_oo.repository.AccountRepository;
import com.dio.challenge.lab_banco_digital_oo.repository.BankRepository;
import com.dio.challenge.lab_banco_digital_oo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BankRepository bankRepository;

    @Autowired
    ClientRepository clientRepository;

    public List<AccountResponse> getAll(){
        List<Account> list = accountRepository.findAll();

        checkListEmpty(list);

        return list.stream()
            .map(AccountDTO::convertTypeAccountDTO).toList();
    }

    public AccountResponse getAccountById(Long id){
        return new AccountResponse(checkAccountInDBAndReturnItem(id));
    }

    public List<AccountResponse> getAllAccountsByOne(Long id){
        List<Account> list = accountRepository.findByClient(getClientBank(id));

        checkListEmpty(list);

        return list.stream()
            .map(AccountDTO::convertTypeAccountDTO).toList();
    }

    public AccountResponse create(AccountRequest request){
        Account account = buildingAccount(request);

        Account result = accountRepository.save(account);

        return new AccountResponse(result);
    }

    public AccountResponse update(Long id, AccountRequestToUpdate typeAccount){
        return buildUpdate(id, typeAccount);
    }

    public void delete(Long id){
        Account account = checkAccountInDBAndReturnItem(id);
        accountRepository.delete(account);
    }

    private AccountResponse buildUpdate(Long id, AccountRequestToUpdate typeAccount){
        Account account = checkAccountInDBAndReturnItem(id);

        account.setTypeAccount(typeAccount.getTypeAccount());

        accountRepository.save(account);

        return new AccountResponse(account);
    }

    private void checkListEmpty(List<Account> list){
        if (list.isEmpty())
            throw new EmptyListException();
    }

    private Account buildingAccount(AccountRequest request){
        List<Account> byNumberAccount = accountRepository.findByNumberAccount(request.getNumberAccount());

        if (byNumberAccount != null){
            for (Account account : byNumberAccount){
                if(account.getBank().getId().equals(request.getBank())){
                    throw new AccountAlreadyExistsException();
                }
            }
        }

        return new Account(new AccountResponse(request),
                            getClientBank(request.getClient()),
                            getBankById(request.getBank()));
    }

    private Bank getBankById(Long idBank){
        return bankRepository.findById(idBank).orElseThrow(BankNotFoundException::new);
    }

    private ClientBank getClientBank(Long idClient){
        return clientRepository.findById(idClient).orElseThrow(ClientNotFoundException::new);
    }

    private Account checkAccountInDBAndReturnItem(Long id){
        return accountRepository.findById(id).orElseThrow(NoFoundAccountException::new);
    }

}
