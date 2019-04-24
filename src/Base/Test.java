package Base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test
{

    private  Map<String,String> usersList= new HashMap<>();

    public  boolean checkUser(String user){

        if(usersList.get(user)!=null)
            return true;
        else return false;
    }





    public  boolean checkUserPass(String user,String pass){

        if(usersList.get(user).equals(pass))
            return true;
        else return false;
    }

    public  Test() {
        initialise();
    }

    private  void initialise(){
        usersList.put("goleshov@my.ru","123");
        usersList.put("g@my.ru","321");
        usersList.put("go@my.ru","222");
    }


}
