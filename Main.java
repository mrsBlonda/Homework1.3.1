import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder str = new StringBuilder();

        File games = new File("Games");
        str.append(printDir(games));
        File dir1 = new File("Games//src");
        File dir2 = new File("Games//res");
        File dir3 = new File("Games//savegames");
        File dir4 = new File("Games//temp");
        str.append(printDir(dir1));
        str.append(printDir(dir2));

        str.append(printDir(dir3));
        str.append(printDir(dir4));
        File srcDir1 = new File("Games//src//main");
        File srcDir2 = new File("Games//src//test");
        str.append(printDir(srcDir1));
        str.append(printDir(srcDir2));
        File main = new File("Games//src//main//Main.java");
        File utils = new File("Games//src//main//Utils.java");
        str.append(printFile(main));
        str.append(printFile(utils));
        File resDir1 = new File("Games//res//drawables");
        File resDir2 = new File("Games//res//vectors");
        File resDir3 = new File("Games//res//icons");
        str.append(printDir(resDir1));
        str.append(printDir(resDir2));
        str.append(printDir(resDir3));
        File temp = new File("Games//temp//temp.text");
        str.append(printFile(temp));

        try(FileWriter writer = new FileWriter("Games//temp//temp.text")) {
            writer.write(String.valueOf(str));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String printDir(File file) {
        if (file.mkdir()) {
            return "Каталог " + file + " создан\n";
        }
        return "Каталог " + file + " НЕ создан\n";
    }

    public static String printFile(File file) {
        try {
            if (file.createNewFile()) {
                return "Файл " + file + " создан\n";
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return "Файл " + file + " НЕ создан\n";
    }

}
