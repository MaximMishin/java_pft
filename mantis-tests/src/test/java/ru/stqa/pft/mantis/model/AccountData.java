package ru.stqa.pft.mantis.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@XStreamAlias("account")
@Entity
@Table(name = "mantis_user_table")
public class AccountData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "username", columnDefinition = "VARCHAR")
  private String username;

  @Column(name = "realname", columnDefinition = "VARCHAR")
  private String realname;

  @Column(name = "email", columnDefinition = "VARCHAR")
  private String email;

  @Column(name = "password", columnDefinition = "VARCHAR")
  private String password;

  @Column(name = "enabled", columnDefinition = "TINYINT")
  private int enabled;

  @Column(name = "protected", columnDefinition = "TINYINT")
  private int secure; // protected;

  @Column(name = "access_level", columnDefinition = "SMALLINT")
  private int access_level;

  @Column(name = "login_count")
  private int login_count;

  @Column(name = "lost_password_request_count", columnDefinition = "SMALLINT")
  private int lost_password_request_count;

  @Column(name = "failed_login_count", columnDefinition = "SMALLINT")
  private int failed_login_count;

  @Column(name = "cookie_string", columnDefinition = "VARCHAR")
  private String cookie_string;

  @Column(name = "last_visit")
  private int last_visit;

  @Column(name = "date_created")
  private int date_created;

  @Transient
  private String link;

  public AccountData withUsername(String username) {
    this.username = username;
    return this;
  }

  public AccountData withRealname(String realname) {
    this.realname = realname;
    return this;
  }

  public AccountData withEmail(String email) {
    this.email = email;
    return this;
  }

  public AccountData withPassword(String password) {
    this.password = password;
    return this;
  }

  public AccountData withEnabled(int enabled) {
    this.enabled = enabled;
    return this;
  }

  public AccountData withSecure(int secure) {
    this.secure = secure;
    return this;
  }

  public AccountData withAccess_level(int access_level) {
    this.access_level = access_level;
    return this;
  }

  public AccountData withLogin_count(int login_count) {
    this.login_count = login_count;
    return this;
  }

  public AccountData withLost_password_request_count(int lost_password_request_count) {
    this.lost_password_request_count = lost_password_request_count;
    return this;
  }

  public AccountData withFailed_login_count(int failed_login_count) {
    this.failed_login_count = failed_login_count;
    return this;
  }

  public AccountData withCookie_string(String cookie_string) {
    this.cookie_string = cookie_string;
    return this;
  }

  public AccountData withLast_visit(int last_visit) {
    this.last_visit = last_visit;
    return this;
  }

  public AccountData withDate_created(int date_created) {
    this.date_created = date_created;
    return this;
  }

  public AccountData withLink(String link) {
    this.link = link;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getRealname() {
    return realname;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public int getEnabled() {
    return enabled;
  }

  public int getSecure() {
    return secure;
  }

  public int getAccess_level() {
    return access_level;
  }

  public int getLogin_count() {
    return login_count;
  }

  public int getLost_password_request_count() {
    return lost_password_request_count;
  }

  public int getFailed_login_count() {
    return failed_login_count;
  }

  public String getCookie_string() {
    return cookie_string;
  }

  public int getLast_visit() {
    return last_visit;
  }

  public int getDate_created() {
    return date_created;
  }

  public String getLink() {
    return link;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AccountData)) return false;

    AccountData that = (AccountData) o;

    if (getId() != that.getId()) return false;
    if (!getUsername().equals(that.getUsername())) return false;
    if (getRealname() != null ? !getRealname().equals(that.getRealname()) : that.getRealname() != null) return false;
    if (!getEmail().equals(that.getEmail())) return false;
    return getPassword().equals(that.getPassword());
  }

  @Override
  public int hashCode() {
    int result = getId();
    result = 31 * result + getUsername().hashCode();
    result = 31 * result + (getRealname() != null ? getRealname().hashCode() : 0);
    result = 31 * result + getEmail().hashCode();
    result = 31 * result + getPassword().hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "AccountData{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", realname='" + realname + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", access_level=" + access_level +
            '}';
  }
}
