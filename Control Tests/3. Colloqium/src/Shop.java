import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Shop {
    private ArrayList<Boots> Container;

    public Shop() {
        Container = new ArrayList<Boots>();
    }

    public void InsertBoot(Boots m_) {
        Container.add(m_);
    }

    public void getBoots(String file_name) throws IOException {
        FileWriter fileWriter = new FileWriter(file_name, true);
        for (int i = 0; i < Container.size(); i++) {
            fileWriter.write(Container.get(i).toString() + "\n");
        }
        fileWriter.write("\n");
        fileWriter.close();
    }

    public void setBoots(String file_name) throws IOException {
        FileReader fileReader = new FileReader(file_name);
        Scanner scanner = new Scanner(fileReader);
        int count = scanner.nextInt();
        String str = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            str = scanner.nextLine();
            Boots boots = new Boots();
            Pattern pattern = Pattern.compile("\"(\\w+)\"");
            Matcher matcher = pattern.matcher(str);
            String name;
            if (matcher.find()) {
                do {
                   name = matcher.group(1);
                } while (matcher.find());
            } else {
                continue;
            }
            pattern = Pattern.compile("[(](\\w+)[)]");
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                do {
                    boots.setName(name + " " + matcher.group(1));
                } while (matcher.find());
            } else {
                continue;
            }
            pattern = Pattern.compile("(\\d+)?[.]([0-9][0-9])");
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                do {
                    boots.setPrice(Double.parseDouble(matcher.group()));

                } while (matcher.find());
            } else {
                continue;
            }
            pattern = Pattern.compile("((0[1-9]|1[0-2])[.]202[0-2])");
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                do {
                    boots.setDate(matcher.group());

                } while (matcher.find());
            } else {
                continue;
            }
            pattern = Pattern.compile("([ ]|^)([1-9]|[1-9][0-9]|100)([ ]|$)");
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                do {
                    try {
                        boots.setCount(Integer.parseInt(matcher.group(2)));
                    } catch (NumberFormatException nfe) {
                        continue;
                    }
                } while (matcher.find());
            } else {
                continue;
            }
            Container.add(boots);
        }
        fileReader.close();
    }

    public void NameSort() {
        Container.sort((Boots lhs, Boots rhs)->{
            return lhs.getName().compareTo(rhs.getName());
        });
    }

    public void PriceSort(){
        Container.sort((Boots lhs, Boots rhs)->{
            return (int)(lhs.getPrice() - rhs.getPrice());
        });
    }

    public void binarySearch(String to_search, String file_name) throws IOException {
        FileWriter fileWriter = new FileWriter(file_name, true);
        Boots boots = new Boots();
        boots.setName(to_search);
        int idx = Collections.binarySearch(Container, boots, Boots::compareTo);
        fileWriter.write("Binary Searched: " + Container.get(idx).toString() + "\n");
        fileWriter.close();
    }

    public List<Boots> getDateBoots(String date, String file_name) throws IOException {
        FileWriter fileWriter = new FileWriter(file_name, true);
        List<Boots> boots = Container.stream().filter(book -> book.getDate().equals(date)).collect(Collectors.toList());
        fileWriter.write("Date " + date + " are :\n");
        for (int i = 0; i < boots.size(); i++) {
            fileWriter.write(boots.get(i).toString() + "\n");
        }
        fileWriter.close();
        return boots;
    }

    public void DateGroupped(String file_name) throws IOException {
        FileWriter fileWriter = new FileWriter(file_name, true);
        Map<String, List<Boots>> medsByFim = new HashMap(Container.stream().collect(Collectors.groupingBy(Boots::getDate)));
        for (Map.Entry<String, List<Boots>> item : medsByFim.entrySet()) {
            fileWriter.write(item.getKey() + " : " + item.getValue() + "\n");
        }
        fileWriter.close();
    }
}

