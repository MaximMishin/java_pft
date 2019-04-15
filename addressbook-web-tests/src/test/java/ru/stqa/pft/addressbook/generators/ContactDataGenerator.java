package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {


  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);

    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContact(count);
    if (format.equals("csv")) {
      saveAsCSV(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXML(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCSV(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts)
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
              contact.getFirstName(),
              contact.getMiddleName(),
              contact.getLastName(),
              contact.getNickName(),
              contact.getTitle(),
              contact.getCompany(),
              contact.getAddress(),
              contact.getHomePhone(),
              contact.getMobilePhone(),
              contact.getWorkPhone(),
              contact.getFax(),
              contact.getEmail1(),
              contact.getEmail2(),
              contact.getEmail3(),
              contact.getHomePage(),
              contact.getBday(),
              contact.getBmonth(),
              contact.getByear(),
              contact.getAday(),
              contact.getAmonth(),
              contact.getAyear(),
              contact.getSecondaryAddress(),
              contact.getPhoneTwo(),
              contact.getNotes(),
              contact.getGroup(),
              contact.getPhoto()));
    writer.close();
  }

  private List<ContactData> generateContact(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData()
              .withFirstName(String.format("FirstName%s", i))
              .withMiddleName(String.format("MiddleName%s", i))
              .withLastName(String.format("LastName%s", i))
              .withNickName(String.format("nickName%s", i))
              .withTitle("title")
              .withCompany("Company")
              .withAddress("address")
              .withHomePhon("757575")
              .withMobilePhone("88005553535")
              .withWorkPhone("575757")
              .withFax("999666")
              .withEmail1("email1@mail.ru")
              .withEmail2("email2@mail.ru")
              .withEmail3("email3@mail.ru")
              .withHomePage("http://homepage")
              .withBday("10")
              .withBmonth("February")
              .withByear("1990")
              .withAday("5")
              .withAmonth("February")
              .withAyear("2020")
              .withSecondaryAddress("Secondary Address")
              .withPhoneTwo("767676")
              .withNotes("notesText")
              .withGroup("test1")
              .withPhoto(new File("src/test/resources/img.jpg")));
    }
    return contacts;
  }
}
