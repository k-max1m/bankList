package bankList;

/**
 * Created by k-max1m on 07.12.2019.
 */
public class User {
    private int userId;
    private int accountId;
    private int account;
    private String name;
    private String sureName;

    public User(int userId, int accountId, int account, String name, String sureName) {
        this.userId = userId;
        this.accountId = accountId;
        this.account = account;
        this.name = name;
        this.sureName = sureName;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (accountId != user.accountId) return false;
        if (account != user.account) return false;
        if (!name.equals(user.name)) return false;
        return sureName.equals(user.sureName);

    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + accountId;
        result = 31 * result + account;
        result = 31 * result + name.hashCode();
        result = 31 * result + sureName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", sureName: " + sureName + ", userId: " + userId + ", accountId: " + accountId + ", account: " + account + ".";
    }
}
