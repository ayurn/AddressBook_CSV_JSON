import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookIOTest {

    @SuppressWarnings("deprecation")
    @Test
    public void givenContactsFromCSVFileShouldRead() {
        AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
        List<Contacts> contactList = new ArrayList<>();
        contactList = addressBookFileIOService.readCSVData();
        System.out.println(contactList);
        Assertions.assertEquals(2, contactList.size());
    }

    @SuppressWarnings("deprecation")
    @Test
    public void writeContactsToCSVFile() {
        AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
        List<Contacts> contactList = new ArrayList<>();
        Contacts contact1 = new Contacts("Ayur", "Ninawe", "amt", "amravati", "MAha", "123456", "7878787878", "aaaaa@yahoo.co.in");
        Contacts contact2 = new Contacts("Shubham", "Raghorte", "NewTown", "nagpur", "Maha", "785478", "9856257845", "bbbbb@gmail.com");
        contactList.add(contact1);
        contactList.add(contact2);
        boolean b = addressBookFileIOService.writeCSVData(contactList);
        Assertions.assertTrue(b);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void writeContactsToJsonFile() {
        AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
        List<Contacts> contactList = new ArrayList<>();
        Contacts contact1 = new Contacts("Ayur", "Ninawe", "amt", "amravati", "MAha", "123456", "7878787878", "aaaaa@yahoo.co.in");
        Contacts contact2 = new Contacts("Shubham", "Raghorte", "NewTown", "nagpur", "Maha", "785478", "9856257845", "bbbbb@gmail.com");
        contactList.add(contact1);
        contactList.add(contact2);
        boolean b = addressBookFileIOService.writeJsonData(contactList);
        Assertions.assertTrue(b);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void readContactsFromJsonFile() {
        AddressBookFileIOService addressBookFileIOService = new AddressBookFileIOService();
        List<Contacts> contactList = new ArrayList<>();
        boolean b = addressBookFileIOService.readJsonFile();
        Assertions.assertTrue(b);
    }
}