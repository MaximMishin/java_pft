package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Accounts extends ForwardingSet<AccountData> {

  private Set<AccountData> delegate;

  public Accounts(Accounts accounts) {
    this.delegate = new HashSet<AccountData>(accounts.delegate);
  }

  public Accounts() {
    this.delegate = new HashSet<AccountData>();
  }

  public Accounts(Collection<AccountData> accounts) {
    this.delegate = new HashSet<AccountData>(accounts);
  }

  @Override
  protected Set<AccountData> delegate() {
    return delegate;
  }

  public Accounts withAdded(AccountData account){
    Accounts users = new Accounts(this);
    users.add(account);
    return users;
  }
  public Accounts withOut(AccountData account){
    Accounts users = new Accounts(this);
    users.remove(account);
    return users;
  }
}
