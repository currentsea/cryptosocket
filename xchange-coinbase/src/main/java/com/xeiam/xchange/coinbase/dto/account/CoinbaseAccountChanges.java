package com.xeiam.xchange.coinbase.dto.account;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeiam.xchange.coinbase.dto.CoinbasePagedResult;
import com.xeiam.xchange.coinbase.dto.marketdata.CoinbaseAmount;

public class CoinbaseAccountChanges extends CoinbasePagedResult {

  private final CoinbaseUser currentUser;
  private final CoinbaseAmount balance;
  private final List<CoinbaseAccountChange> accountChanges;

  public CoinbaseAccountChanges(@JsonProperty("current_user") final CoinbaseUser currentUser, @JsonProperty("balance") final CoinbaseAmount balance,
      @JsonProperty("account_changes") final List<CoinbaseAccountChange> accountChanges, @JsonProperty("total_count") final int totalCount, @JsonProperty("num_pages") final int numPages,
      @JsonProperty("current_page") final int currentPage) {

    super(totalCount, numPages, currentPage);
    this.currentUser = currentUser;
    this.balance = balance;
    this.accountChanges = accountChanges;
  }

  public CoinbaseUser getCurrentUser() {

    return currentUser;
  }

  public CoinbaseAmount getBalance() {

    return balance;
  }

  public List<CoinbaseAccountChange> getAccountChanges() {

    return accountChanges;
  }

  @Override
  public String toString() {

    return "CoinbaseAccountChanges [currentUser=" + currentUser + ", balance=" + balance + ", accountChanges=" + accountChanges + "]";
  }

}
