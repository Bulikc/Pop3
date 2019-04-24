package StateClient;



import  Base.Test;
public class AUTHORIZATION implements Commads{

    private String user;

    private String pass;
    private boolean chek=false;
    private boolean isAuthorization=false;
    private Test testBase;



    public AUTHORIZATION(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    private void error(){
        user=null;
        pass=null;
        chek=false;
        isAuthorization=false;
    }

    public AUTHORIZATION() {
         testBase=new Test();
    }

    public boolean USER2(String user){

        chek=true;
        this.user=user;
        if(testBase.checkUser(user))
        return true;
        else return false;
    }

    public String USER(String user){

        chek=true;
        this.user=user;
      // System.out.println("run USER "+user);
        return "+OK name is a valid mailbox";
    }

    public String STAT(String user){

        chek=true;
        this.user=user;
        // System.out.println("run USER "+user);
        return "+OK 0 0";
    }


    public String QUIT(String user){

        chek=true;
        this.user=user;
        // System.out.println("run USER "+user);
        return "+OK ";
    }



    public boolean isAuthorization() {
        return isAuthorization;
    }

    public String PASS(String pass)
    {
        this.pass=pass;


        if((chek)&&(check(pass))){

            isAuthorization=true;
            return "+OK maildrop locked and ready";}
        else{
            error();
            return "-ERR invalid password";}
    }


    public boolean check(String pass){
        System.out.println("run "+this.user+" "+this.pass);
        if(testBase.checkUserPass(this.user,this.pass))
        return true;
        else return false;

    }





    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public String getArgument() {
        return null;
    }

    @Override
    public String getMethod() {
        return null;
    }
}
