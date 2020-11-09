package create;

import java.io.*;

public class CreateFile {

    public void writeFile(String nameFile, Object o) {
        try {
            FileOutputStream fos = new FileOutputStream(nameFile);
            ObjectOutputStream oss = new ObjectOutputStream(fos);
            oss.writeObject(o);
            oss.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Object readFile(String nameFile) {
        Object obj = null;
        try {
            FileInputStream fis = new FileInputStream(nameFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            ois.close();
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

}
