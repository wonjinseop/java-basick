package etc.api.io.obj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadSnack {
    
    public static void main(String[] args) {
    
        try(FileInputStream fis = new FileInputStream("C:/myWorkspace/snack.sav")) {
        
            // 객체를 불러올 보조 스트림
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            List<Snack> snackList = (List<Snack>) ois.readObject();
            
            for (Snack snack : snackList) {
                System.out.println(snack);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
