import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.*;

public class AddressBookFileIOService {


    public static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\AYUR\\IdeaProjects\\AddressBook_CSV_Json\\src\\main\\java\\ContactList.csv";
    public static final String SAMPLE_CSV_FILE_PATH2 = "C:\\Users\\AYUR\\IdeaProjects\\AddressBook_CSV_Json\\src\\main\\java\\ContactList1.csv";


    @SuppressWarnings("unchecked")
    public List<Contacts> readCSVData() {
        List<Contacts> contactsList = new ArrayList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBean<Contacts> csvToBean = new CsvToBeanBuilder<Contacts>(reader).withType(Contacts.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            contactsList = csvToBean.parse();
            reader.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return contactsList;
    }

    public boolean writeCSVData(List<Contacts> contactList) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH2))) {
            StatefulBeanToCsv<Contacts> beanToCsv = new StatefulBeanToCsvBuilder<Contacts>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

            beanToCsv.write(contactList);
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}