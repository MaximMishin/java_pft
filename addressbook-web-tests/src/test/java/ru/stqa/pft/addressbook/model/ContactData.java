package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickName;
  private final String title;
  private final String company;
  private final String address;
  private final String homePhon;
  private final String mobilePhone;
  private final String workPhone;
  private final String fax;
  private final String email1;
  private final String email2;
  private final String email3;
  private final String homePage;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String aday;
  private final String amonth;
  private final String ayear;
  private final String secondaryAddress;
  private final String phoneTwo;
  private final String notes;
  private final String group;

  public ContactData(String firstName, String middleName, String lastName,
                     String nickName, String title, String company,
                     String address, String homePhon, String mobilePhone,
                     String workPhone, String fax,
                     String email1, String email2, String email3, String homePage,
                     String bday, String bmonth, String byear,
                     String aday, String amonth, String ayear,
                     String secondaryAddress, String phoneTwo, String notes,
                     String group) {
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
}
