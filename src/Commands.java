import StateClient.AUTHORIZATION;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Commands {


    private boolean isAuthorization=false;
    private Method startMethod;
    private Class methodClass ;
    private Object instance ;
    private String[] args;
    private String comand="";
    public String getComand() {
        return comand;
    }
    Class[] params;
    AUTHORIZATION  autorize;
    public Commands() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
          autorize=new AUTHORIZATION();
        params = new Class[] { String.class};
        AUTHORIZATION authorization=new AUTHORIZATION();
        methodClass=authorization.getClass();
       // methodClass = Class.forName("StateClient.AUTHORIZATION");
        instance = methodClass.newInstance();

    }

    private void clear(){
        this.comand = null;
        this.args = null;
    }




    private void CommandanAlysis(String line) throws ClassNotFoundException {
        if(line.indexOf(" ")>0){
            args=line.split(" ");
            comand=args[0];
            String[] array2 = new String[args.length-1];
            for(int i=1;i<args.length;i++){
                array2[i-1]=args[i];
            }
            args=array2;
        }else{
            args=new String[0];
            comand=line;}
    }

    public boolean isAuthorization() {
        return isAuthorization;
    }


//    public String  AuthorizationCommand2(String line) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        String rezult="";
//        CommandanAlysis(line);
//        methodClass = Class.forName("StateClient.AUTHORIZATION");
//        instance = methodClass.newInstance();
//        AUTHORIZATION  autorize=new AUTHORIZATION();
//        Class[] params = new Class[] { Boolean.class};
//
//    }


    public String  AuthorizationCommand(String line) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String rezult="-ERR";
        CommandanAlysis(line);


        System.out.println("comand="+params.length);
        System.out.println("comand="+params[0]);
        try {
          //  System.out.println("commands="+comand);
            startMethod = methodClass.getMethod(comand, params);
            System.out.println(args.length);
            if(args.length==0){
                args=new String[1];
                args[0]="heeef";
            }
            rezult=startMethod.invoke(instance, args).toString();

            startMethod = methodClass.getMethod("isAuthorization()", Boolean.class);
            String Authorization=startMethod.invoke(instance, null).toString();
             isAuthorization=Boolean.parseBoolean(rezult);
           // System.out.println("auto "+isAuthorization);
                   }
        catch (NoSuchMethodException e)
        {
            clear();
        } catch (InvocationTargetException e) {
            clear();
        }
        clear();
        return rezult;
    }



    public String  executeCommand(String line)throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException{
        String rezult="-ERR command not found";
        methodClass = Class.forName("StateClient.AUTHORIZATION");
        instance = methodClass.newInstance();
        CommandanAlysis(line);

            AUTHORIZATION  autorize=new AUTHORIZATION();
            Class[] params = new Class[] { String.class};

            try {
                startMethod = methodClass.getMethod(comand, params);
              //  System.out.println(m.invoke(instance, command)+"get");
                rezult=startMethod.invoke(instance, args).toString();
                this.comand = comand;
            //    this.argument = argument;

            }
            catch (NoSuchMethodException e)
            {
               clear();
            }

        clear();
    return rezult;
    }



//    public Commands(String line) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        if(line.indexOf(" ")>0){
//        String[] mas=line.split(" ");
////          System.out.println(mas[0]+" "+mas[1]);
//        AUTHORIZATION  autorize=new AUTHORIZATION();
//        //Class clas=autorize.getClass().ge
//        Class c = Class.forName("StateClient.AUTHORIZATION");
//        Object instance = c.newInstance();
//        Class[] params = new Class[] { String.class};
//
//        try {
//            Method m = c.getMethod(mas[0], params);
//            System.out.println(m.invoke(instance, mas[0])+"get");
//            this.comand = comand;
//            this.argument = argument;
//        }
//        catch (NoSuchMethodException e)
//        {
//            this.comand = null;
//            this.argument = null;
//        }
//       }
//        this.comand = null;
//        this.argument = null;
//
//    }

    public void getCommand(){

    }
}
