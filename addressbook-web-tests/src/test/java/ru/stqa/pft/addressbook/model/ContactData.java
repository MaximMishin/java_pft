package ru.stqa.pft.addressbook.model;


import java.util.Objects;

public class ContactData {
  private int id;
  private final String firstName;
  private String middleName;
  private final String lastName;
  private String nickName;
  private String title;
  private String company;
  private String address;
  private String homePhon;
  private String mobilePhone;
  private String workPhone;
  private String fax;
  private String email1;
  private String email2;
  private String email3;
  private String homePage;
  private String bday;
  private String bmonth;
  private String byear;
  private String aday;
  private String amonth;
  private String ayear;
  private String secondaryAddress;
  private String phoneTwo;
  private String notes;
  private String group;

  public ContactData(String firstName, String middleName, String lastName,
                     String nickName, String title, String company,
                     String address, String homePhon, String mobilePhone,
                     String workPhone, String fax,
                     String email1, String email2, String email3, String homePage,
                     String bday, String bmonth, String byear,
                     String aday, String amonth, String ayear,
                     String secondaryAddress, String phoneTwo, String notes,
                     String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.homePhon = homePhon;
    this.mobilePhone = mobilePhone;
    this.workPhone = workPhone;
    this.fax = fax;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.homePage = homePage;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.aday = aday;
    this.amonth = amonth;
    this.ayear = ayear;
    this.secondaryAddress = secondaryAddress;
    this.phoneTwo = phoneTwo;
    this.notes = notes;
    this.group = group;
  }

  public ContactData(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhon() {
    return homePhon;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomePage() {
    return homePage;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getAday() {
    return aday;
  }

  public String getAmonth() {
    return amonth;
  }

  public String getAyear() {
    return ayear;
  }

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getPhoneTwo() {
    return phoneTwo;
  }

  public String getNotes() {
    return notes;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}
